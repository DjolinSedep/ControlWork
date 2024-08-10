package kg.attractor.controlw.controller;

import kg.attractor.controlw.dto.AccountDto;
import kg.attractor.controlw.dto.TransactionDto;
import kg.attractor.controlw.model.Account;
import kg.attractor.controlw.repository.AccountRepository;
import kg.attractor.controlw.repository.UserRepository;
import kg.attractor.controlw.service.AccountService;
import kg.attractor.controlw.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/accounts")
    public ResponseEntity<String> createAccount(@RequestBody AccountDto accountDto) {

        Object user = userRepository.findById(accountDto.getUserId()).orElse(null);
        if (user == null) {
            return new ResponseEntity<>("Пользователь не найден", HttpStatus.NOT_FOUND);
        }

        Account account = accountService.createAccount(accountDto.getCurrency(), BigDecimal.ZERO, () );
        return new ResponseEntity<>("Счет создан", HttpStatus.CREATED);
    }

    @GetMapping("/accounts/balance")
    public ResponseEntity<BigDecimal> getAccountBalance(@RequestParam Long accountId) {
        AccountRepository accountRepository = new AccountRepository();
        Optional<Account> account = accountRepository.findById(accountId);
        if (account.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account.get().getBalance(), HttpStatus.OK);
    }

    @PostMapping("/accounts/balance")
    public ResponseEntity<String> depositToAccount(@RequestBody TransactionDto transactionDto) {

        AccountRepository accountRepository = new AccountRepository();
        Optional<Account> accountOpt = accountRepository.findById(transactionDto.getAccountId());
        if (accountOpt.isEmpty()) {
            return new ResponseEntity<>("Счет не найден", HttpStatus.NOT_FOUND);
        }

        Account account = accountOpt.get();
        accountService.deposit(account, transactionDto.getAmount());
        return new ResponseEntity<>("Баланс обновлен", HttpStatus.OK);
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAllAccounts() {
        AccountRepository accountRepository = new AccountRepository();
        List<Account> accounts = accountRepository.findAll();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/transactions/{accountId}/history")
    public ResponseEntity<List<TransactionDto>> getTransactionHistory(@PathVariable Long accountId) {
        List<TransactionDto> transactions = transactionService.getTransactionHistory(accountId);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @PostMapping("/transactions")
    public ResponseEntity<String> makeTransaction(@RequestBody TransactionDto transactionDto) {

        boolean success = transactionService.makeTransaction(transactionDto);
        if (success) {
            return new ResponseEntity<>("Транзакция успешна", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Ошибка транзакции", HttpStatus.BAD_REQUEST);
        }
    }
}

