package com.example;

public enum CardsNumGrade {
    //定数
    ACE(13),
    KING(12),
    QUEEN(11),
    JACK(10),
    TEN(9),
    NINE(8),
    EIGHT(7),
    SEVEN(6),
    SIX(5),
    FIVE(4),
    FOUR(3),
    THREE(2),
    TWO(1);

    //フィールド
    private final int cardsNumGrade;

    //コンストラクタ
    private CardsNumGrade(int cardsNumGrade) {
        this.cardsNumGrade = cardsNumGrade;
    }
}
