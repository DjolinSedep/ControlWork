package kg.attractor.controlw.repository;

import kg.attractor.controlw.model.Account;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AccountRepository  extends JpaRepository<Account, Number> {
    public AccountRepository accountRepository = new AccountRepository();


    public List<Account> findByUserId(Long userId) {
        return null;
    }

    List<Account> findByUserIdAndCurrency(Long userId, String currency) {
        return null;
    }

    public void save(Account account1) {
    }

    public Optional<Account> findById(Long accountId) {
        return null;
    }

    public List<Account> findAll() {
        return null;
    }
}
