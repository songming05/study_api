package stripe.song.accounts.repository;

import java.time.Instant;

public class AccountEntity {
    public final String accountId;
    public final Instant created;
    public final String defaultCurrency;
    public final String email;
    public final Double monthlyPayment;

    public AccountEntity(String accountId, Instant created, String defaultCurrency, String email, Double monthlyPayment) {
        this.accountId = accountId;
        this.created = created;
        this.defaultCurrency = defaultCurrency;
        this.email = email;
        this.monthlyPayment = monthlyPayment;
    }
}
