package data;

public class Card {

    public Card(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    private final String cardNumber;

    public String getCardNumber() {
        return cardNumber;
    }

}