package com.example;

public enum Cards {
    //定数
    //スペード
    SPADE_ACE(1, "♤"),
    SPADE_TWO(2, "♤"),
    SPADE_THREE(3, "♤"),
    SPADE_FOUR(4, "♤"),
    SPADE_FIVE(5, "♤"),
    SPADE_SIX(6, "♤"),
    SPADE_SEVEN(7, "♤"),
    SPADE_EIGHT(8, "♤"),
    SPADE_NINE(9, "♤"),
    SPADE_TEN(10, "♤"),
    SPADE_JACK(11, "♤"),
    SPADE_QUEEN(12, "♤"),
    SPADE_KING(13, "♤"),
    //ハート
    HEART_ACE(1, "♡"),
    HEART_TWO(2, "♡"),
    HEART_THREE(3, "♡"),
    HEART_FOUR(4, "♡"),
    HEART_FIVE(5, "♡"),
    HEART_SIX(6, "♡"),
    HEART_SEVEN(7, "♡"),
    HEART_EIGHT(8, "♡"),
    HEART_NINE(9, "♡"),
    HEART_TEN(10, "♡"),
    HEART_JACK(11, "♡"),
    HEART_QUEEN(12, "♡"),
    HEART_KING(13, "♡"),
    //ダイヤ
    DIAMOND_ACE(1, "♢"),
    DIAMOND_TWO(2, "♢"),
    DIAMOND_THREE(3, "♢"),
    DIAMOND_FOUR(4, "♢"),
    DIAMOND_FIVE(5, "♢"),
    DIAMOND_SIX(6, "♢"),
    DIAMOND_SEVEN(7, "♢"),
    DIAMOND_EIGHT(8, "♢"),
    DIAMOND_NINE(9, "♢"),
    DIAMOND_TEN(10, "♢"),
    DIAMOND_JACK(11, "♢"),
    DIAMOND_QUEEN(12, "♢"),
    DIAMOND_KING(13, "♢"),
    //クローバー
    CLUB_ACE(1, "♧"),
    CLUB_TWO(2, "♧"),
    CLUB_THREE(3, "♧"),
    CLUB_FOUR(4, "♧"),
    CLUB_FIVE(5, "♧"),
    CLUB_SIX(6, "♧"),
    CLUB_SEVEN(7, "♧"),
    CLUB_EIGHT(8, "♧"),
    CLUB_NINE(9, "♧"),
    CLUB_TEN(10, "♧"),
    CLUB_JACK(11, "♧"),
    CLUB_QUEEN(12, "♧"),
    CLUB_KING(13, "♧");

    //フィールド
    private final int cardsNum;

    private final String suit;
    //コンストラクタ

    private Cards(int cardsNum, String suit) {
        this.cardsNum = cardsNum;
        this.suit = suit;
    }
}
