package stripe.song.accounts.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/api/v1/accounts/{id}")
    public String retrieveAccount(@PathVariable String id) {

        return "retrieveAccount: "+id;
    }
}
