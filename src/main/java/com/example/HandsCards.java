package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;

/**
 * 手札に対して行う処理を用意したクラスです。
 */
public class HandsCards {

    /**
     * 引数で指定された枚数山札からcardを引き、手札に追加するメソッドです。
     * 山札: cardsList
     * 指定枚数 : drawCardNum
     * 手札: handsCard
     */
    public static void getRandomCards(List<Cards> cardsList, int drawCardNum, List<Cards> handsCard) {

        for (int i = 0; i < drawCardNum; i++) {
            Random random = new Random();
            int index = random.nextInt(cardsList.size());
            Cards card = cardsList.get(index);
            handsCard.add(card);
            cardsList.remove(index);
        }

    }

    /**
     * 手札のsuitに1~5に順に番号を振り、Listに格納するメソッドです。
     * 手札: handsCardList
     */
    public static List<List<String>> getHandsCardValues(List<Cards> handsCardList) {
        List<List<String>> handsCardsValueList = new ArrayList<>();
        for (int i = 0; i < handsCardList.size(); i++) {
            String cardsData = handsCardList.get(i).getCard();
            List<String> card = new ArrayList<>(List.of(cardsData, Integer.valueOf(i + 1).toString()));
            handsCardsValueList.add(card);
        }
        System.out.println();
        return handsCardsValueList;
    }

    /**
     * 手札のsuitをsoutで表示させるメソッドです。
     * 手札: handsCardList
     */
    public static void openHandsCardValues(List<Cards> handsCardList) {
        for (Cards cards : handsCardList) {
            String cardsData = cards.getCard();
            System.out.print(cardsData + " ");
        }
        System.out.println();
    }

    /**
     * 手札のsuitに1~5の連番をsoutで表示させるメソッドです。
     * 手札: handsCardList
     */
    public static void printSNum(List<Cards> handsCardList, List<List<String>> handsCardsValueList) {
        int numIndex = 1;
        for (int i = 0; i < handsCardList.size(); i++) {
            System.out.print(handsCardsValueList.get(i).get(numIndex) + "   ");
        }
        System.out.println();
    }

    /**
     * numOfCards枚分、交換するカードを削除し新しいカードを山札から追加するメソッドです。
     * 手札: handsCardList
     * 交換する枚数: numOfCards
     */
    public static void choiceRemoveCards(int numOfCards, List<List<String>> handsCardsValueList, List<Cards> playersHandsCardsList, List<Cards> cardsList) {
        //手札を1枚以上交換する際の処理
        Scanner sc = new Scanner(System.in);
        //交換する枚数分、この後入力される、”交換するカードの番号”取得の繰り返し
        for (int i = 0; i < numOfCards; i++) {
            //交換するカードの番号を取得
            int changeCardNum = sc.nextInt();
            //handsCardsValueListから、changeCardNumと一致する交換するカードの値を取得するまで繰り返す
            for (int j = 0; j < handsCardsValueList.size(); j++) {
                //handsCardsValueListの連番とchangeCardNumが一致した場合の処理
                if (Integer.parseInt(handsCardsValueList.get(j).get(1)) == changeCardNum) {
                    playersHandsCardsList.remove(j);
                    handsCardsValueList.remove(j);
                    // removeをすると、indexの値がずれてしまうため、指定したカードとは違うカードが削除されてしまっている。
                    // →handsCardsValueListからも削除することで、indexの不一致を解決
                }
            }
        }
        System.out.println(playersHandsCardsList); //確認用
        // 選択した数ぶん、山札からランダムに選んだカードを追加する
        HandsCards.getRandomCards(cardsList, numOfCards, playersHandsCardsList);
        System.out.println(playersHandsCardsList); //確認用
    }

    /**
     * numOfCards枚分、CPUの交換するカードを削除するメソッドです。
     * 手札: handsCardList
     * 交換する枚数: numOfCards
     */
    public static void cpuChangeCards(int cpuNumOfCards, List<List<String>> cpuHandsCardsValueList, List<Cards> cpusHandsCardsList) {
        for (int i = 0; i < cpuNumOfCards; i++) {
            //交換するカードの番号を取得
            int changeCardNum = i + 1;
            //handsCardsValueListから、changeCardNumと一致する交換するカードの値を取得するまで繰り返す
            for (int j = 0; j < cpuHandsCardsValueList.size(); j++) {
                //handsCardsValueListの連番とchangeCardNumが一致した場合の処理
                if (Integer.parseInt(cpuHandsCardsValueList.get(j).get(1)) == changeCardNum) {
                    cpusHandsCardsList.remove(j);
                    cpuHandsCardsValueList.remove(j);
                    // removeをすると、indexの値がずれてしまうため、指定したカードとは違うカードが削除されてしまっている。
                    // →handsCardsValueListからも削除することで、indexの不一致を解決
                }
            }
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
