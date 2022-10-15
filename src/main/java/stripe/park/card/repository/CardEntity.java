package stripe.park.card.repository;

import java.time.LocalDateTime;

public class CardEntity {

    public final String cardId;
    public final String funding;
    public final String brand;
    public final String country;
    public final String name;
    public final Integer exp_month;
    public final Integer exp_year;

    public final Integer last4;
    public final LocalDateTime createdTime;

    public CardEntity(String cardId, String funding, String brand, String country, String name, Integer exp_month, Integer exp_year, Integer last4, LocalDateTime createdTime) {
        this.cardId = cardId;
        this.funding = funding;
        this.brand = brand;
        this.country = country;
        this.name = name;
        this.exp_month = exp_month;
        this.exp_year = exp_year;
        this.last4 = last4;
        this.createdTime = createdTime;
    }
}
