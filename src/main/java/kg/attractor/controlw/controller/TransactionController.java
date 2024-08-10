package kg.attractor.controlw.controller;

import kg.attractor.controlw.model.Transaction;
import kg.attractor.controlw.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/{accountId}/history")
    public ResponseEntity<List<Transaction>> getTransactionHistory(@PathVariable Integer accountId) {
        List<Transaction> transactions = transactionRepository.findByFromAccountIdOrToAccountId(accountId, accountId);

        if (transactions.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(transactions);
    }
}
