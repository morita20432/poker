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
        } else if (fourOfAKind(handsCardsList)) {
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

        return cardNumList.get(0) == 1 && straight(handsCardsList) && flush(handsCardsList);
    }

    /**
     * 役がストレートフラッシュか判定するメソッドです。
     */
    public static boolean straightFlush(List<Cards> handsCardsList) {
        return flush(handsCardsList) && straight(handsCardsList);
    }

    /**
     * 役がフォーカードか判定するメソッドです。
     */
    public static boolean fourOfAKind(List<Cards> handsCardsList) {
        List<Integer> cardNumList = getCardNumList(handsCardsList);

        for (int i = 0; i < 3; i++) {
            if (cardNumList.get(i) != cardNumList.get(i + 1) && cardNumList.get(i + 1) != cardNumList.get(i + 2)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 役がフルハウスか判定するメソッドです。
     */
    public static boolean fullHouse(List<Cards> handsCardsList) {
        List<Integer> cardNumList = getCardNumList(handsCardsList);
        return (cardNumList.get(0) == cardNumList.get(1) && cardNumList.get(1) == cardNumList.get(2)) && (cardNumList.get(3) == cardNumList.get(4)) ||
                (cardNumList.get(0) == cardNumList.get(1)) && (cardNumList.get(2) == cardNumList.get(3) && cardNumList.get(3) == cardNumList.get(4));
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

        //if(カードの値=1,10,11,12,13の場合true)
        if (cardNumList.get(0) == 1 && cardNumList.get(1) == 10 && cardNumList.get(2) == 11 && cardNumList.get(3) == 12 && cardNumList.get(4) == 13) {
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
    public static boolean threeOfAKind1(List<Cards> handsCardsList) {
        List<Integer> cardNumList = getCardNumList(handsCardsList);
        for (int i = 0; i < 2; i++) {
            if (cardNumList.get(i) != cardNumList.get(i + 1) && cardNumList.get(i + 1) != cardNumList.get(i + 2) && cardNumList.get(i + 2) != cardNumList.get(i + 3)) {
                return false;
            }
        }
        return true;
    }

    public static boolean threeOfAKind(List<Cards> handsCardsList) {
        List<Integer> cardNumList = getCardNumList(handsCardsList);
        return (cardNumList.get(0) == cardNumList.get(1) && cardNumList.get(1) == cardNumList.get(2)) ||
                (cardNumList.get(1) == cardNumList.get(2) && cardNumList.get(2) == cardNumList.get(3)) ||
                (cardNumList.get(2) == cardNumList.get(3) && cardNumList.get(3) == cardNumList.get(4));

    }

    /**
     * 役がツーペアか判定するメソッドです。
     */
    public static boolean twoPair(List<Cards> handsCardsList) {
        List<Integer> cardNumList = getCardNumList(handsCardsList);
        return (cardNumList.get(0) == cardNumList.get(1) && cardNumList.get(2) == cardNumList.get(3)) ||
                (cardNumList.get(1) == cardNumList.get(2) && cardNumList.get(3) == cardNumList.get(4)) ||
                (cardNumList.get(0) == cardNumList.get(1) && cardNumList.get(3) == cardNumList.get(4));
    }

    /**
     * 役がワンペアか判定するメソッドです。
     */
    public static boolean onePair(List<Cards> handsCardsList) {
        List<Integer> cardNumList = getCardNumList(handsCardsList);

        return cardNumList.get(0) == cardNumList.get(1) ||
                cardNumList.get(1) == cardNumList.get(2) ||
                cardNumList.get(2) == cardNumList.get(3) ||
                cardNumList.get(3) == cardNumList.get(4);
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
        } else if (playerHandsGrade.getHandsGrade() < cpuHandsGrade.getHandsGrade()) {
            System.out.println("プレイヤーの敗北です");
        } else {
            System.out.println("引き分けです");
        }
    }

    /**
     * 手札のカードの数字をListで返すメソッドです
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
