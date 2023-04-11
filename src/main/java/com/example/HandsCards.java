package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HandsCards {

    //配列ではなくリスト型にした理由 = 元々の要素数や値が変化することはないが、ポーカーを進行する上で山札は減っていくため
    // 引数で渡された数分だけ、山札からカードを引く処理
    public static void getRandomCards(List<Cards> cardsList, int drawCardNum, List<Cards> handsCard) {

        for (int i = 0; i < drawCardNum; i++) {
            Random random = new Random();
            int index = random.nextInt(cardsList.size());
            Cards card = cardsList.get(index);
            handsCard.add(card);
            cardsList.remove(index);
        }

    }

    // todo 二次元配列になっている手札の中身を表示させる処理
    public static List<List<String>> openHandsCard(List<Cards> handsCardList) {
        List<List<String>> handsCardsValueList = new ArrayList<>();
        for (int i = 0; i < handsCardList.size(); i++) {
            String cardsData = handsCardList.get(i).getCard();
            List<String> card = new ArrayList<>(List.of(cardsData, Integer.valueOf(i + 1).toString()));
            handsCardsValueList.add(card);
            System.out.print(cardsData + " ");
        }
        System.out.println();
//        for (int j = 0; j < handsCardList.size(); j++) {
//            System.out.print(handsCardsValueList.get(j).get(numIndex) + "   ");
//        }
//        System.out.println();
        return handsCardsValueList;
    }

    public static void printSNum(List<Cards> handsCardList, List<List<String>> handsCardsValueList) {
        int numIndex = 1;
        for (int i = 0; i < handsCardList.size(); i++) {
            System.out.print(handsCardsValueList.get(i).get(numIndex) + "   ");
        }
        System.out.println();
    }

    // todo 指定されたカードを手札から特定する処理
    public static void choiceRemoveCards(int numOfCards, List<List<String>> handsCardsValueList, List<Cards> playersHandsCardsList, List<Cards> cardsList) {
        //手札を1枚以上交換する際の処理
        if (0 < numOfCards && numOfCards < 6) {
            Scanner sc = new Scanner(System.in);
            System.out.println("手札から交換したいカードの番号を入力してください。");

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
            System.out.println(playersHandsCardsList);
            // todo 選択した数ぶん、山札からランダムに選んだカードを追加する
            HandsCards.getRandomCards(cardsList, numOfCards, playersHandsCardsList); // todo drawCardに選択したカードの枚数を保持した変数を入れる
            System.out.println(playersHandsCardsList);
        } else if (5 < numOfCards) {
            System.out.println("エラーが発生しました");
            //error発生処理
        }
    }
}
