package stripe.park.card.service;

import org.springframework.stereotype.Service;
import stripe.park.card.repository.CardEntity;
import stripe.park.card.repository.CardRepository;

import java.time.LocalDateTime;

@Service
public class CardService {

    private final CardIdGenerator cardIdGenerator;
    private final CardRepository cardRepository;

    public CardService(CardIdGenerator cardIdGenerator, CardRepository cardRepository) {
        this.cardIdGenerator = cardIdGenerator;
        this.cardRepository = cardRepository;
    }


    public Card create(CardCreationRequest cardCreationRequest) {
        String cardId = cardIdGenerator.generate();

        CardEntity entity = new CardEntity(cardId, cardCreationRequest.funding, cardCreationRequest.brand, cardCreationRequest.country, cardCreationRequest.name, null, null, 1234, LocalDateTime.now());
        cardRepository.save(entity);

        return new Card(cardId, entity.funding, entity.brand, entity.country, entity.name, entity.exp_month, entity.exp_year, entity.last4, entity.createdTime);
    }
}
