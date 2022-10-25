package stripe.song.accounts.service;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import stripe.song.accounts.common.Account;
import stripe.song.accounts.common.AccountId;
import stripe.song.accounts.repository.AccountEntity;
import stripe.song.accounts.repository.AccountRepository;

import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account retrieve(@NonNull AccountId accountId) {
        Objects.requireNonNull(accountId);
        AccountEntity accountEntity = Optional.ofNullable(accountRepository.retreiveById(accountId))
                .orElseThrow(() -> new NoSuchElementException("해당하는 ID의 계정을 찾을 수 없습니다."));

        return new Account(new AccountId(accountEntity.accountId), accountEntity.created,
                accountEntity.defaultCurrency, accountEntity.email, accountEntity.monthlyPayment);
    }

    public List<Account> retrieveList(int count) {
        //TODO
        return null;
    }


    public Account create() {
        AccountId accountId = new AccountId(AccountIdGenerator.generate());
        Account account = new Account(accountId, Instant.now(), "USD", null, 0.0);
        accountRepository.save(account);
        return account;
    }
}
