package com.example;

public enum HandsGrade {
    //定数
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

    //フィールド
    private final int handsGrade;

    //コンストラクタ
    private HandsGrade(int handsGrade) {
        this.handsGrade = handsGrade;
    }

    //メソッド
    public String judgeHands(String suits) {
        return "a";
    }
    }

//handsEnumでコンストラクタに役の強さ、スートの強さ、数字の強さを引数に設定すると、定数で全パターン記載が必要になる。

//役enumでやりたいこと＝役を全て定数化したい。
//各役の強さ順を定義したい。
//各数字の強さ順を定義したい。
//各スートの強さ順を定義したい。
