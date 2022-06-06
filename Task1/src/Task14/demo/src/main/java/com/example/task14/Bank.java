package com.example.task14;

import java.util.ArrayList;

public class Bank {
    private String name;
    private String address;
    private ArrayList<Card> cards = new ArrayList<>();


    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public Bank(String name) {
        this.name = name;
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public String getBankName() {
        return name;
    }

    public void setBankName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getStudents() {
        return cards;
    }

    public void setStudents(ArrayList<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bank name='" + name + '\'' +
                ", cards=" + cards +
                '}';
    }
}
