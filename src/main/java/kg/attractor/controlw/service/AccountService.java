package kg.attractor.controlw.service;

import kg.attractor.controlw.model.Account;
import kg.attractor.controlw.model.User;
import kg.attractor.controlw.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {

    public Account createAccount(String currency, BigDecimal balance, User user) {

        AccountRepository accountRepository = new AccountRepository();
        List<Account> userAccounts = accountRepository.findByUserId(user.getId());
        if (userAccounts.size() >= 3) {
            throw new IllegalStateException("Превышено количество счетов у пользователя");
        }
        if (userAccounts.stream().anyMatch(acc -> acc.getCurrency().equals(currency))) {
            throw new IllegalStateException("Счет с данной валютой уже существует");
        }

        Account account = Account.builder()
                .currency(currency)
                .balance(balance)
                .user(user)
                .build();

    }

    public void deposit(Account account, BigDecimal amount) {
    }
}
