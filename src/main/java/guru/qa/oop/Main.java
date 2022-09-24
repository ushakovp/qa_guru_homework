package guru.qa.oop;

import guru.qa.oop.data.Card;
import guru.qa.oop.data.Country;
import guru.qa.oop.data.MasterCard;

public class Main {

    public static void main(String[] args) {
        invoke(new MasterCard());
    }

    public static void invoke(Card card) {
        card.setBalance(100);
        card.payInCountry(Country.RU, 1);
        System.out.println(card);
    }
}
