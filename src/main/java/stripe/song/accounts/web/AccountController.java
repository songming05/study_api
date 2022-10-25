package stripe.song.accounts.web;

import org.springframework.web.bind.annotation.*;
import stripe.song.accounts.common.Account;
import stripe.song.accounts.common.AccountId;
import stripe.song.accounts.service.AccountService;

import java.util.List;
import java.util.Optional;

@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/api/v1/accounts/{id}")
    public AccountRetreiveResultResponse retrieveAccount(@PathVariable String id) {

        AccountId accountId = new AccountId(id);
        Account account = accountService.retrieve(accountId);
        return new AccountRetreiveResultResponse(account.accountId);
    }

    @GetMapping("/api/v1/accounts")
    public AccountRetreiveListResultResponse retrieveAccountList(@RequestParam(required = false) String count) {

        String maybeCount = Optional.ofNullable(count).orElse("20");
        int limit = Integer.parseInt(maybeCount);

        //TODO
        List<Account> accountList = accountService.retrieveList(limit);
        return new AccountRetreiveListResultResponse();
    }

    @PostMapping("/api/v1/accounts")
    public AccountCreationResponse createAcoount() {
        Account account = accountService.create();
        return new AccountCreationResponse(account.accountId);
    }

}
