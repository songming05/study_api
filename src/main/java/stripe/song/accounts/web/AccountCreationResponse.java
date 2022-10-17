package stripe.song.accounts.web;

import stripe.song.accounts.common.AccountId;

public class AccountCreationResponse {
    public final AccountId id;

    public AccountCreationResponse(AccountId accountId) {
        this.id = accountId;
    }
}
