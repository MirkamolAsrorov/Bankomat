package com.example.bankomat.model.enums;

public enum CardTypes {
    HUMO("9860"),UZCARD("8600"),
    VISA("4000");
    private final String cards;
    //
    CardTypes(String cards) {
        this.cards = cards;
    }

    public String getCards() {
        return cards;
    }

}
