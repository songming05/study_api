package stripe.song.accounts.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stripe.song.accounts.common.Account;
import stripe.song.accounts.repository.AccountRepository;

import static org.assertj.core.api.Assertions.*;

class AccountServiceTest {

    @Test
    @DisplayName("계정을 신규로 생성한다")
    void create_account_by_new_id() {
        AccountRepository accountRepository = new AccountRepository();
        AccountService accountService = new AccountService(accountRepository);
        Account newAccount = accountService.create();
        assertThat(newAccount).isNotNull();
        assertThat(newAccount.accountId.value).isEqualTo(accountRepository.retreiveById(newAccount.accountId).accountId);
    }



}