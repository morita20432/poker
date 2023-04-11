package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Cards {
    //定数
    //スペード
    SPADE_ACE("♤1", 1, 13, 4),
    SPADE_TWO("♤2", 2, 1, 4),
    SPADE_THREE("♤3", 3, 2, 4),
    SPADE_FOUR("♤4", 4, 3, 4),
    SPADE_FIVE("♤5", 5, 4, 4),
    SPADE_SIX("♤6", 6, 5, 4),
    SPADE_SEVEN("♤7", 6, 6, 4),
    SPADE_EIGHT("♤8", 8, 7, 4),
    SPADE_NINE("♤9", 9, 8, 4),
    SPADE_TEN("♤10", 10, 9, 4),
    SPADE_JACK("♤11", 11, 10, 4),
    SPADE_QUEEN("♤12", 12, 11, 4),
    SPADE_KING("♤13", 13, 12, 4),
    //ハート
    HEART_ACE("♡1", 1, 13, 3),
    HEART_TWO("♡2", 2, 1, 3),
    HEART_THREE("♡3", 3, 2, 3),
    HEART_FOUR("♡4", 4, 3, 3),
    HEART_FIVE("♡5", 5, 4, 3),
    HEART_SIX("♡6", 6, 5, 3),
    HEART_SEVEN("♡7", 7, 6, 3),
    HEART_EIGHT("♡8", 8, 7, 3),
    HEART_NINE("♡9", 9, 8, 3),
    HEART_TEN("♡10", 10, 9, 3),
    HEART_JACK("♡11", 11, 10, 3),
    HEART_QUEEN("♡12", 12, 11, 3),
    HEART_KING("♡13", 13, 12, 3),
    //ダイヤ
    DIAMOND_ACE("♢1", 1, 13, 2),
    DIAMOND_TWO("♢2", 2, 1, 2),
    DIAMOND_THREE("♢3", 3, 2, 2),
    DIAMOND_FOUR("♢4", 4, 3, 2),
    DIAMOND_FIVE("♢5", 5, 4, 2),
    DIAMOND_SIX("♢6", 6, 5, 2),
    DIAMOND_SEVEN("♢7", 7, 6, 2),
    DIAMOND_EIGHT("♢8", 8, 7, 2),
    DIAMOND_NINE("♢9", 9, 8, 2),
    DIAMOND_TEN("♢10", 10, 9, 2),
    DIAMOND_JACK("♢11", 11, 10, 2),
    DIAMOND_QUEEN("♢12", 12, 11, 2),
    DIAMOND_KING("♢13", 13, 12, 2),
    //クローバー
    CLUB_ACE("♧1", 1, 13, 1),
    CLUB_TWO("♧2", 2, 1, 1),
    CLUB_THREE("♧3", 3, 2, 1),
    CLUB_FOUR("♧4", 4, 3, 1),
    CLUB_FIVE("♧5", 5, 4, 1),
    CLUB_SIX("♧6", 6, 5, 1),
    CLUB_SEVEN("♧7", 7, 6, 1),
    CLUB_EIGHT("♧8", 8, 7, 1),
    CLUB_NINE("♧9", 9, 8, 1),
    CLUB_TEN("♧10", 10, 9, 1),
    CLUB_JACK("♧11", 11, 10, 1),
    CLUB_QUEEN("♧12", 12, 11, 1),
    CLUB_KING("♧13", 13, 12, 1);

    //フィールド
    private final String suit;

    private final int cardNum;

    private final int cardsNumGrade;

    private final int suitGrade;

    //コンストラクタ
    private Cards(String suit, int cardNum, int cardsNumGrade, int suitGrade) {
        this.suit = suit;
        this.cardNum = cardNum;
        this.cardsNumGrade = cardsNumGrade;
        this.suitGrade = suitGrade;
    }

    public static List<Cards> createCardsList() {
        return new ArrayList<>(Arrays.asList(Cards.values()));
    }

    public String getCard() {
        return suit;
    }

    public int getCardNumGrade() {
        return cardsNumGrade;
    }

    public int getSuitGrade() {
        return suitGrade;
    }
}
