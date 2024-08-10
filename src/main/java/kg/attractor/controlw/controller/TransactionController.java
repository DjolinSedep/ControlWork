package kg.attractor.controlw.controller;

import kg.attractor.controlw.dto.TransactionDto;
import kg.attractor.controlw.model.Account;
import kg.attractor.controlw.model.Transaction;
import kg.attractor.controlw.repository.AccountRepository;
import kg.attractor.controlw.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/{accountId}/history")
    public ResponseEntity<List<Transaction>> getTransactionHistory(@PathVariable Integer accountId) {
        List<Transaction> transactions = transactionRepository.findByFromAccountIdOrToAccountId(accountId, accountId);

        if (transactions.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(transactions);
    }

        @PostMapping
        public ResponseEntity<String> createTransaction(@RequestBody TransactionDto request) {
            Account fromAccount = accountRepository.findById(request.getFromAccountId())
                    .orElse(null);
            Account toAccount = accountRepository.findById(request.getToAccountId())
                    .orElse(null);

            if (fromAccount == null || toAccount == null) {
                return new ResponseEntity<>("Один или оба счета не найдены", HttpStatus.NOT_FOUND);
            }

            if (!fromAccount.getCurrency().equals(toAccount.getCurrency())) {
                return new ResponseEntity<>("Валюты счетов не совпадают", HttpStatus.BAD_REQUEST);
            }

            if (fromAccount.getBalance().compareTo(request.getAmount()) < 0) {
                return new ResponseEntity<>("Недостаточно средств на счете", HttpStatus.BAD_REQUEST);
            }

            fromAccount.setBalance(fromAccount.getBalance().subtract(request.getAmount()));
            toAccount.setBalance(toAccount.getBalance().add(request.getAmount()));

            Transaction transaction = Transaction.builder()
                    .fromAccount(fromAccount)
                    .toAccount(toAccount)
                    .amount(request.getAmount())
                    .currency(fromAccount.getCurrency())
                    .status(request.getAmount().compareTo(BigDecimal.valueOf(10)) > 0 ? "PENDING" : "APPROVED")
                    .build();

            transactionRepository.save(transaction);
            accountRepository.save(fromAccount);
            accountRepository.save(toAccount);

            return new ResponseEntity<>("Транзакция успешно создана", HttpStatus.CREATED);
        }
    }

