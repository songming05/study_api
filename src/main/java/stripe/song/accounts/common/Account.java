package stripe.song.accounts.common;

import java.time.Instant;

public class Account {

    public final AccountId accountId;
    public final Instant created;
    public final String defaultCurrency;
    public final String email;
    public final Double monthlyPayment;
    //public final Country country;
    //public final String disabledReason;

    public Account(AccountId accountId, Instant created, String defaultCurrency, String email, Double monthlyPayment) {
        this.accountId = accountId;
        this.created = created;
        this.defaultCurrency = defaultCurrency;
        this.email = email;
        this.monthlyPayment = monthlyPayment;
    }

    //  "country": "US",
    //  "created": 1385798567,
    //  "default_currency": "usd",
    //  "email": "site@stripe.com",
    //  "external_accounts": {
    //    "object": "list",
    //    "data": [],
    //    "has_more": false,
    //    "url": "/v1/accounts/acct_1032D82eZvKYlo2C/external_accounts"
    //  },
    //  "payouts_enabled": false,

}
