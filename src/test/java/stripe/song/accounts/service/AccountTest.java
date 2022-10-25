package stripe.song.accounts.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stripe.song.accounts.common.Account;
import stripe.song.accounts.common.AccountId;

import java.time.Instant;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import static org.assertj.core.api.Assertions.*;
public class AccountTest {

    @Test
    @DisplayName("created의 적절한 타입을 결정하기 위한 테스트")
    void evaluate_suitable_type() {
        //  "created": 1385798567,
        Instant instant = Instant.now();
        System.out.println("instant = " + instant);
        Instant createdInstant = Instant.ofEpochSecond(1385798567L);
        System.out.println("createdInstant = " + createdInstant);

        Account account = new Account(new AccountId(AccountIdGenerator.generate()), Instant.now().minus(3L, ChronoUnit.DAYS)
                , "KRW", "abc@xyz.com", 14900D);
        assertThat(account).isNotNull();
        System.out.println("account.created = " + account.created);
    }
}
