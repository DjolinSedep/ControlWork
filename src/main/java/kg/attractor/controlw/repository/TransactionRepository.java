package kg.attractor.controlw.repository;

import kg.attractor.controlw.model.Transaction;

import java.util.List;

public class TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByFromAccountIdOrToAccountId(Integer fromAccountId, Integer toAccountId) {
     return findByFromAccountIdOrToAccountId(fromAccountId, toAccountId);
    }

}
