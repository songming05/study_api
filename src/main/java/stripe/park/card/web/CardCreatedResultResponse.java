package stripe.park.card.web;

import stripe.park.card.service.Card;

import java.time.LocalDateTime;

public class CardCreatedResultResponse {
    public String cardId;
    public LocalDateTime createdTime;

    public CardCreatedResultResponse(Card card) {
        this.cardId = card.cardId;
        this.createdTime = card.createdTime;
    }
}
