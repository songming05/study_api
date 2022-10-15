package stripe.park.card.web;

import org.springframework.web.bind.annotation.*;
import stripe.park.card.service.Card;
import stripe.park.card.service.CardCreationRequest;
import stripe.park.card.service.CardService;

@RestController
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("api/v1/cards/{id}")
    public CardRetrieveResultResponse retrieveCard(@PathVariable String id) {
        return new CardRetrieveResultResponse(id);
    }

    @PostMapping("api/v1/cards")
    public CardCreatedResultResponse createCard(@RequestBody CardRequestDto cardRequestDto) {

        Card card = cardService.create(new CardCreationRequest(cardRequestDto.funding, cardRequestDto.brand, cardRequestDto.country, cardRequestDto.name));

        return new CardCreatedResultResponse(card);
    }
}
