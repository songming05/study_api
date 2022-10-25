package stripe.song.accounts.repository;

import org.springframework.stereotype.Component;
import stripe.song.accounts.common.Account;
import stripe.song.accounts.common.AccountId;

import java.util.HashMap;
import java.util.Map;

@Component
public class AccountRepository {
    Map<String, AccountEntity> database = new HashMap<>();

    public String save(Account account) {
        if (database.containsKey(account.accountId.value)) throw new IllegalArgumentException();
        AccountEntity accountEntity = new AccountEntity(account.accountId.value);
        database.put(account.accountId.value, accountEntity);
        return account.accountId.value;
    }

    public Account retreiveById(AccountId accountId) {
        AccountEntity accountEntity = database.get(accountId.value);
        return new Account(new AccountId(accountEntity.accountId));
    }
}