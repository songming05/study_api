package stripe.song.accounts.service;

import org.springframework.stereotype.Service;
import stripe.song.accounts.common.Account;
import stripe.song.accounts.common.AccountId;
import stripe.song.accounts.repository.AccountRepository;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account retreive(AccountId accountId) {
        //TODO
        return null;
    }

    public List<Account> retreiveList(int count) {
        //TODO
        return null;
    }


    public Account create() {
        AccountId accountId = new AccountId(AccountIdGenerator.generate());
        Account account = new Account(accountId);
        accountRepository.save(account);
        return account;
    }
}
