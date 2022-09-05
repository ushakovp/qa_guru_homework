package guru.qa.oop;

import guru.qa.oop.data.Card;
import guru.qa.oop.data.Country;
import guru.qa.oop.data.MasterCard;
import guru.qa.oop.data.VisaCard;

public class Main {

    public static void main(String[] args) {
        Card card = new MasterCard();
        VisaCard visa = new VisaCard();
        visa.payInCountry(Country.RU, 1);
        card.payInCountry(Country.RU, 1);
        System.out.println(card);
        System.out.println(visa);
    }
}
