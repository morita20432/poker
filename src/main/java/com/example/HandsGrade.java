package com.example;

public enum HandsGrade {


    ROYALFLUSH(10),
    STRAIGHTFLUSH(9),
    FOROFAKIND(8),
    FULLHOUSE(7),
    FLUSH(6),
    STRAIGHT(5),
    THREEOFAKIND(4),
    TWOPAIR(3),
    ONEPAIR(2),
    NOPAIR(1);

    /**
     * 役の強さを1<10の数値で表した値です。
     */
    private final int handsGrade;

    private HandsGrade(int handsGrade) {
        this.handsGrade = handsGrade;
    }
}
