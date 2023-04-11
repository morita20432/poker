package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("ポーカーを始めます");
        //52枚のカードのリストを生成
        List<Cards> cardsList = Cards.createCardsList();

        //52枚からランダムに5枚選択し、ArrayListに格納する
        List<Cards> playersHandsCardsList = new ArrayList<>(); //プレイヤーの手札を生成
        HandsCards.getRandomCards(cardsList, 5, playersHandsCardsList); //cardsListは47枚になる。

        System.out.println(playersHandsCardsList); //確認用:プレイヤーの手札
        System.out.println(cardsList.size());
        //47枚からランダムに5枚選択し、ArrayListに格納する
        List<Cards> cpusHandsCardsList = new ArrayList<>(); //cpuの手札を生成
        HandsCards.getRandomCards(cardsList, 5, cpusHandsCardsList); //cardsListは42枚になる。

        System.out.println(cpusHandsCardsList); //確認用:CPUの手札
        System.out.println(cardsList.size());

        //プレイヤーにランダム抽出された5枚のカードを表示させる
        List<List<String>> handsCardsValueList = HandsCards.openHandsCard(playersHandsCardsList);

        //カードに1~5の連番を振る
        HandsCards.printSNum(playersHandsCardsList, handsCardsValueList);
        //todo 5枚のカードのうち、変えたいカードを選択させる
        System.out.println("手札から交換したいカードの枚数を入力してください。");
        System.out.println("交換しない場合は0と入力してください。");
        Scanner sc = new Scanner(System.in);
        int numOfCards = sc.nextInt();

        HandsCards.choiceRemoveCards(numOfCards, handsCardsValueList, playersHandsCardsList, cardsList);

        // todo CPUの手札をランダムな枚数交換する

        //交換した後の手札をプレイヤーに見せる
        HandsCards.openHandsCard(playersHandsCardsList);

        // todo プレイヤー,CPU手札の役を確認する

        // todo プレイヤー,CPUの手札の役を比較する

        // todo プレイヤーの役の方が強い場合win,弱い場合lose
    }
}
