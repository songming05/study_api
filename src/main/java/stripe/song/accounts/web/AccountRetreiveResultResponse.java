package stripe.song.accounts.web;

import stripe.song.accounts.common.AccountId;

public class AccountRetreiveResultResponse {
    public final AccountId id;

    public AccountRetreiveResultResponse(AccountId accountId) {
        this.id = accountId;
    }
}
