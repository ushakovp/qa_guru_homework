package guru.qa.oop.data;

public class MirCard extends Card {
    public MirCard() {
        super(PaymentSystem.MIR);
    }

    protected boolean isCountryValidForThisCard(Country country) {
        return Country.RU == country;
    }
}
