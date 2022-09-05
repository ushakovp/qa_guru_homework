package guru.qa.oop.data;

public abstract class Card {

    String cardHolder;
    int balance;
    String cardNumber;
    PaymentSystem paymentSystem;

    public abstract void payInCountry(Country country, int amount);

    public PaymentSystem getPaymentSystem() {
        return paymentSystem;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardHolder='" + cardHolder + '\'' +
                ", balance=" + balance +
                ", cardNumber='" + cardNumber + '\'' +
                ", paymentSystem=" + paymentSystem +
                '}';
    }
}
