package com.example.task14;

public class Card {
    private String cardNumber;
    private String code;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }



    @Override
    public String toString() {
        return "Card{" +
                "card Number='" + cardNumber + '\'' +
                ", card code='" + code + '\'' +'}';
    }

    public Card(String cardNumber, String code) {
        this.cardNumber = cardNumber;
        this.code = code;
    }
}
