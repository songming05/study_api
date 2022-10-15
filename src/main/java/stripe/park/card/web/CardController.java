package stripe.park.card.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

    @GetMapping("api/v1/cards/{id}")
    public CardRetrieveResultResponse retrieveCard(@PathVariable String id) {
        return new CardRetrieveResultResponse(id);
    }
}
