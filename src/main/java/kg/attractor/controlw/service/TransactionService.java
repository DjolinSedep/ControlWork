package kg.attractor.controlw.service;

import kg.attractor.controlw.dto.TransactionDto;

import java.util.List;

public interface TransactionService {

    boolean makeTransaction(TransactionDto transactionDto);

    List<TransactionDto> getTransactionHistory(Long accountId);

    List<TransactionDto> getAllTransactions();
}
