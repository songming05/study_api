package stripe.song.accounts.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stripe.song.accounts.common.Account;
import stripe.song.accounts.common.AccountId;
import stripe.song.accounts.repository.AccountRepository;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("AccountId로 단건 Account 조회, 미존재일 경우 오류")
    void retrieve_account_by_id_or_throw(){
        AccountRepository accountRepository = new AccountRepository();
        AccountService accountService = new AccountService(accountRepository);
        Account newAccount = accountService.create();

        Account retrieve = accountService.retrieve(newAccount.accountId);
        assertThat(retrieve).isNotNull();
        AccountId invalidAccountId = new AccountId(AccountIdGenerator.generate());
        accountService.retrieve(invalidAccountId);
//        assertThat()
//        assertThatThrownBy(accountService.retrieve(accountId))

    }



}