package course.springdata.service.impl;

import course.springdata.dao.AccountRepository;
import course.springdata.entity.Account;
import course.springdata.entity.User;
import course.springdata.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    @Autowired
    public AccountServiceImpl setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        return this;
    }

    @Override
    public Account createUserAccount(User user, Account account) {
        account.setId(null);
        account.setUser(user);
        user.getAccounts().add(account);
        return accountRepository.save(account);
    }

    @Override
    public void withdrawMoney(BigDecimal amount, Long accountId) {

    }

    @Override
    public void depositMoney(BigDecimal amount, Long accountId) {

    }

    @Override
    public void transferMoney(BigDecimal amount, Long fromAccountId, Long toAccountId) {

    }


}
