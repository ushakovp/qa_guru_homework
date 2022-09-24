package guru.qa.oop.data;

public abstract class Card {

    protected String cardHolder;
    protected int balance;
    protected String cardNumber;
    protected PaymentSystem paymentSystem;

    public Card(PaymentSystem paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    protected boolean isBalanceGreaterThan(int amount) {
        return balance >= amount;
    }

    public void payInCountry(Country country, int amount) {
        if (isCountryValidForThisCard(Country.RU) && isBalanceGreaterThan(amount)) {
            balance = balance - amount;
            System.out.println("Accepted!");
        }
    }

    protected abstract boolean isCountryValidForThisCard(Country country);

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public PaymentSystem getPaymentSystem() {
        return paymentSystem;
    }

    public void setPaymentSystem(PaymentSystem paymentSystem) {
        this.paymentSystem = paymentSystem;
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
