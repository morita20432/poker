package com.example;

public enum SuitsGrade {
    //定数
    SPADE(4),
    HEART(3),
    DIAMOND(2),
    CLUB(1);

    //フィールド
    private final int suitGrade;

    //コンストラクタ
    private SuitsGrade(int suitGrade) {
        this.suitGrade = suitGrade;
    }

}
