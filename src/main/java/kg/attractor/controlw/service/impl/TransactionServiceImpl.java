package kg.attractor.controlw.service.impl;

import kg.attractor.controlw.dto.TransactionDto;
import kg.attractor.controlw.model.Transaction;
import kg.attractor.controlw.repository.AccountRepository;
import kg.attractor.controlw.repository.TransactionRepository;
import kg.attractor.controlw.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionServiceImpl implements TransactionService {

    private final AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public boolean makeTransaction(TransactionDto transactionDto) {
        return false;
    }

    @Override
    public List<TransactionDto> getTransactionHistory(Long accountId) {
        return List.of();
    }

    @Override
    public List<TransactionDto> getAllTransactions() {
        AccountRepository transactionRepository = new AccountRepository();
        Object transactions = transactionRepository.findAll();
        return transactions.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    private TransactionDto convertToDto(Transaction transaction) {
        return TransactionDto.builder()
                .toAccountId(transaction.getId())
                .AccountId(transaction.getFromAccount().getId())
                .toAccountId(transaction.getToAccount().getId())
                .amount(transaction.getAmount())
                .createdAt(transaction.getCreatedAt())
                .build();
    }
    }
}
