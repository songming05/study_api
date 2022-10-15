package stripe.park.card.repository;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CardRepository {

    private Map<String, CardEntity> database = new HashMap<>();

    public void save(CardEntity entity) {
        if (database.containsKey(entity.cardId)) {
            throw new RuntimeException("Duplicate key");
        }
        database.put(entity.cardId, entity);
    }
}
