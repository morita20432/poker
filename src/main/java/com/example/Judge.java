package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 互いの役を判定、公開するクラスです。
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

    public static void royal(List<Cards> handsCardsList) {
        int cardNumIndex = 1;
        List<Integer> cardNumList = new ArrayList<>();
        List<Integer> straightList = new ArrayList<>();
        straightList.add(10);
        straightList.add(11);
        straightList.add(12);
        straightList.add(13);
        straightList.add(1);
        for (Cards cards : handsCardsList) {
            cardNumList.add(cards.getCardNum());
        }
        for (int straight : straightList) {
            if (cardNumList.contains(straight)) {

            }
        }
    }

    public static void royalFlush1(List<Cards> handsCardsList) {
        //手札のCardNumの数値を

        for (Cards cards : handsCardsList) {
            int num = cards.getCardNum();
        }

    }

    /**
     * 役がロイヤルストレートフラッシュか判定するメソッドです。
     */
    public static boolean royalStraightFlush(List<Cards> handsCardsList) {
        List<Integer> cardNumGradeList = new ArrayList<>();
        for (Cards cards : handsCardsList) {
            cardNumGradeList.add(cards.getCardNumGrade());
        }
        //カードの強さでsort
        Collections.sort(cardNumGradeList);

        if (cardNumGradeList.get(0) == 10) {
            if (straight(handsCardsList)) {
                return flush(handsCardsList);
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    /**
     * 役がストレートフラッシュか判定するメソッドです。
     */
    public static boolean straightFlush(List<Cards> handsCardsList) {
        if (!royalStraightFlush(handsCardsList)) {
            return flush(handsCardsList) && straight(handsCardsList);
        } else {
            return false;
        }
    }

    /**
     * 役がフォーカードか判定するメソッドです。
     */
    public static boolean forOfAKind(List<Cards> handsCardsList) {
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
        List<Integer> cardNumGradeList = new ArrayList<>();
        for (Cards cards : handsCardsList) {
            cardNumGradeList.add(cards.getCardNumGrade());
        }
        //カードの強さでsort
        Collections.sort(cardNumGradeList);

        //sort後の最小gradeが1(2)かつ、最大grade13(A)場合
        if (cardNumGradeList.get(0) == 1 && cardNumGradeList.get(4) == 13) {
            //ACEのgradeを0に変更
            cardNumGradeList.set(4, 0);
            //再び昇順でsort
            Collections.sort(cardNumGradeList);
        }
        for (int i = 0; i < 4; i++) {
            if (cardNumGradeList.get(i) != cardNumGradeList.get(i + 1) - 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 役がスリーカードか判定するメソッドです。
     */
    public static boolean threeOfAKind(List<Cards> handsCardsList) {
        return true;
    }

    /**
     * 役がツーペアか判定するメソッドです。
     */
    public static boolean twoPair(List<Cards> handsCardsList) {
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
}
