package com.example;

import java.util.ArrayList;
import java.util.List;

public class Judge {
    public static void checkHands(List<Cards> handsCardsList) {
        if (flush(handsCardsList)) {

        }
    }

    public static void royalFlush(List<Cards> handsCardsList) {
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
     * 役がフラッシュか判定するメソッドです。
     */
    public static boolean flush(List<Cards> handsCardsList) {
        List<Integer> suitList = new ArrayList<>();
        for (Cards cards : handsCardsList) {
            suitList.add(cards.getSuitGrade());
        }
        for (int i = 0; i < 4; i++) {
            if (suitList.get(i) != suitList.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 役がストレートか判定するメソッドです。
     */
    public static boolean straight() {
        return true;
    }

    public static void judgeHands() {

    }

}
