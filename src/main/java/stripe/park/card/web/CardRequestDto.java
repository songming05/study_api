package stripe.park.card.web;

public class CardRequestDto {

    public final String funding;
    public final String brand;
    public final String country;
    public final String name;

    public CardRequestDto(String funding, String brand, String country, String name) {
        this.funding = funding;
        this.brand = brand;
        this.country = country;
        this.name = name;
    }
}
