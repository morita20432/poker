package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 役に関係するメソッドをまとめたクラスです。
 */
public class Judge {

    /**
     * 引数で受け取った手札がどの役か判定するメソッドです。
     */
    public static HandsGrade checkHands(List<Cards> handsCardsList) {

        if (royalStraightFlush(handsCardsList)) {
            return HandsGrade.ROYALFLUSH;
        } else if (straightFlush(handsCardsList)) {
            return HandsGrade.STRAIGHTFLUSH;
        } else if (forOfAKind(handsCardsList)) {
            return HandsGrade.FOROFAKIND;
        } else if (fullHouse(handsCardsList)) {
            return HandsGrade.FULLHOUSE;
        } else if (flush(handsCardsList)) {
            return HandsGrade.FLUSH;
        } else if (straight(handsCardsList)) {
            return HandsGrade.STRAIGHT;
        } else if (threeOfAKind(handsCardsList)) {
            return HandsGrade.THREEOFAKIND;
        } else if (twoPair(handsCardsList)) {
            return HandsGrade.TWOPAIR;
        } else if (onePair(handsCardsList)) {
            return HandsGrade.ONEPAIR;
        } else {
            return HandsGrade.NOPAIR;
        }
    }

    /**
     * 役がロイヤルストレートフラッシュか判定するメソッドです。
     */
    public static boolean royalStraightFlush(List<Cards> handsCardsList) {
        List<Integer> cardNumList = getCardNumList(handsCardsList);

        return cardNumList.get(0) == 10 && straight(handsCardsList) && flush(handsCardsList);
    }

    /**
     * 役がストレートフラッシュか判定するメソッドです。
     */
    public static boolean straightFlush(List<Cards> handsCardsList) {
        if (royalStraightFlush(handsCardsList)) {
            return false;
        } else {
            return flush(handsCardsList) && straight(handsCardsList);
        }
    }

    /**
     * 役がフォーカードか判定するメソッドです。
     */
    public static boolean forOfAKind(List<Cards> handsCardsList) {
        List<Integer> cardNumList = getCardNumList(handsCardsList);

        //todo これだとロジックが機能しないので修正
        for (int i = 0; i < 3; i++) {
            if (cardNumList.get(i) != cardNumList.get(i + 1)) {
                return false;
            } else if (cardNumList.get(i + 1) != cardNumList.get(i + 2)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 役がフルハウスか判定するメソッドです。
     */
    public static boolean fullHouse(List<Cards> handsCardsList) {
        return true;
    }

    /**
     * 役がフラッシュか判定するメソッドです。
     */
    public static boolean flush(List<Cards> handsCardsList) {
        List<Integer> suitGradeList = new ArrayList<>();
        for (Cards cards : handsCardsList) {
            suitGradeList.add(cards.getSuitGrade());
        }
        for (int i = 0; i < 4; i++) {
            if (suitGradeList.get(i) != suitGradeList.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 役がストレートか判定するメソッドです。
     */
    public static boolean straight(List<Cards> handsCardsList) {
        List<Integer> cardNumList = getCardNumList(handsCardsList);

//        //sort後の最小gradeが1(カードの数字:2)かつ、最大grade13(カードの数字:A)の場合
//        if (cardNumList.get(0) == 1 && cardNumList.get(4) == 13) {
//            //ACEのgradeを0に変更
//            cardNumList.set(4, 0);
//            //再び昇順でsort
//            Collections.sort(cardNumList);
//        }

        //todo if(カードの値=1,10,11,12,13の場合true)
        if (cardNumList.get(0) == 1 && cardNumList.get(1) == 10 && cardNumList.get(2) == 11 && cardNumList.get(3) == 12 && cardNumList.get(3) == 13) {
            return true;
        }
        //それ以外のストレートの組み合わせの場合か検証
        for (int i = 0; i < 4; i++) {
            if (cardNumList.get(i) != cardNumList.get(i + 1) - 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 役がスリーカードか判定するメソッドです。
     */
    public static boolean threeOfAKind(List<Cards> handsCardsList) {
        List<Integer> cardNumList = getCardNumList(handsCardsList);
        //todo ロジック見直し
        for (int i = 0; i < 2; i++) {
            if (cardNumList.get(i) == cardNumList.get(i + 1)) {
                return true;
            } else if (cardNumList.get(i + 1) == cardNumList.get(i + 2)) {
                return true;
            } else if (cardNumList.get(i + 2) == cardNumList.get(i + 3)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 役がツーペアか判定するメソッドです。
     */
    public static boolean twoPair(List<Cards> handsCardsList) {
        //todo フォーカード、フルハウス、フラッシュ、スリーカードでないことの証明
        return true;
    }

    /**
     * 役がワンペアか判定するメソッドです。
     */
    public static boolean onePair(List<Cards> handsCardsList) {

        return true;
    }

    /**
     * 役を公開するメソッドです
     * HandsGradeを引数で受け取って、その役をsoutします
     */
    public static void openHandsGrade(HandsGrade playerHandsGrade, String user) {
        if (playerHandsGrade == HandsGrade.ROYALFLUSH) {
            System.out.println(user + "役はロイヤルストレートフラッシュです");
        } else if (playerHandsGrade == HandsGrade.STRAIGHTFLUSH) {
            System.out.println(user + "役はストレートフラッシュです");
        } else if (playerHandsGrade == HandsGrade.FOROFAKIND) {
            System.out.println(user + "役はフォーカードです");
        } else if (playerHandsGrade == HandsGrade.FULLHOUSE) {
            System.out.println(user + "役はフルハウスです");
        } else if (playerHandsGrade == HandsGrade.FLUSH) {
            System.out.println(user + "役はフラッシュです");
        } else if (playerHandsGrade == HandsGrade.STRAIGHT) {
            System.out.println(user + "役はストレートです");
        } else if (playerHandsGrade == HandsGrade.THREEOFAKIND) {
            System.out.println(user + "役はスリーカードです");
        } else if (playerHandsGrade == HandsGrade.TWOPAIR) {
            System.out.println(user + "役はツーペアです");
        } else if (playerHandsGrade == HandsGrade.ONEPAIR) {
            System.out.println(user + "役はワンペアです");
        } else {
            System.out.println(user + "役はありません");
        }
    }

    /**
     * プレイヤーの役とcpuの役を比較するメソッドです
     * HandsGradeを引数で受け取って、その数値を比較します
     */
    // todo 引数で手札のスート、カードの強さの値を受け取る必要あり
    //  elseで同じ役の場合、数値比較、スート比較のロジックを書く必要がある
    public static void judgeHands(HandsGrade playerHandsGrade, HandsGrade cpuHandsGrade) {
        if (playerHandsGrade.getHandsGrade() > cpuHandsGrade.getHandsGrade()) {
            System.out.println("プレイヤーの勝利です");
        } else {
            System.out.println("プレイヤーの敗北です");
        }
    }

    /**
     * 手札のカードの強さをListで返すメソッドです
     */
    public static List<Integer> getCardNumList(List<Cards> handsCardsList) {
        List<Integer> cardNumList = new ArrayList<>();
        for (Cards cards : handsCardsList) {
            cardNumList.add(cards.getCardNum());
        }
        //昇順で並び替え
        Collections.sort(cardNumList);
        return cardNumList;
    }
}

//todo jUnitテスト作成
