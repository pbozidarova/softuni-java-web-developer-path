package course.springdata.service.impl;

import course.springdata.dao.AccountRepository;
import course.springdata.entity.Account;
import course.springdata.entity.User;
import course.springdata.exception.InvalidAccountOperationException;
import course.springdata.exception.NonExistingEntityException;
import course.springdata.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
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
        Account account = accountRepository
                 .findById(accountId)
                 .orElseThrow(() ->
                         new NonExistingEntityException(
                                 String.format("Entity with ID:%s does not exist.", accountId)
                         )
                 );

        if (account.getBalance().compareTo(amount) < 0 ){
            throw new InvalidAccountOperationException(
                    String.format(
                            "Account ID:%s balance (%s) is less than required withdraw amount (%s)",
                            accountId, account.getBalance(), amount)
            );
        }

        account.setBalance( account.getBalance().subtract(amount) );
    }//commit transaction - @Transactional

    @Override
    public void depositMoney(BigDecimal amount, Long accountId) {
        Account account = accountRepository
                .findById(accountId)
                .orElseThrow(() ->
                        new NonExistingEntityException(
                                String.format("Entity with ID:%s does not exist.", accountId)
                        )
                );

        account.setBalance( account.getBalance().add(amount) );
    }

    @Override
    public void transferMoney(BigDecimal amount, Long fromAccountId, Long toAccountId) {
        depositMoney(amount, toAccountId);
        withdrawMoney(amount, fromAccountId);

    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

}
