package kg.attractor.controlw.repository;

import kg.attractor.controlw.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionRepository extends JpaRepository<Transaction, Integer> {

    public List<Transaction> findByFromAccountIdOrToAccountId(Integer fromAccountId, Integer toAccountId) {
     return findByFromAccountIdOrToAccountId(fromAccountId, toAccountId);
    }

    public void save(Transaction transaction) {
    }
}
