package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * ポーカーを実行するクラスです。
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("ポーカーを始めます");
        //52枚のカードのリストを生成
        List<Cards> cardsList = Cards.createCardsList();

        //52枚からランダムに5枚選択し、ArrayListに格納する
        //プレイヤーの手札を生成
        List<Cards> playersHandsCardsList = new ArrayList<>();
        //cardsListは47枚になる。
        HandsCards.getRandomCards(cardsList, 5, playersHandsCardsList);

        System.out.println(playersHandsCardsList); //確認用:プレイヤーの手札
        System.out.println(cardsList.size()); //確認用:山札サイズ
        //47枚からランダムに5枚選択し、ArrayListに格納する
        //cpuの手札を生成
        List<Cards> cpusHandsCardsList = new ArrayList<>();
        //cardsListは42枚になる。
        HandsCards.getRandomCards(cardsList, 5, cpusHandsCardsList);

        System.out.println(cpusHandsCardsList); //確認用:CPUの手札
        System.out.println(cardsList.size()); //確認用:山札サイズ

        //プレイヤーにランダム抽出された5枚のカードを表示させる
        List<List<String>> playerHandsCardsValueList = HandsCards.getHandsCardValues(playersHandsCardsList);
        HandsCards.openHandsCardValues(playersHandsCardsList);
        //カードに1~5の連番を振る
        HandsCards.printSNum(playersHandsCardsList, playerHandsCardsValueList);
        //5枚のカードのうち、変えたいカードを選択させる
        System.out.println("手札から交換したいカードの枚数を入力してください。");
        System.out.println("交換しない場合は0と入力してください。");

        //手札の枚数をnumOfCardsで取得
        Scanner sc = new Scanner(System.in);
        int numOfCards = sc.nextInt();

        //交換枚数が1枚以上だった場合処理を行う
        if (0 < numOfCards) {
            System.out.println("手札から交換したいカードの番号を入力してください。");
            //numOfCards枚分、交換するカードを削除し新しいカードを山札から追加する処理
            HandsCards.choiceRemoveCards(numOfCards, playerHandsCardsValueList, playersHandsCardsList, cardsList);
        } else {
            System.out.println(playerHandsCardsValueList);
        }

        List<List<String>> cpuHandsCardsValueList = HandsCards.getHandsCardValues(cpusHandsCardsList);

        System.out.println("確認用" + cpuHandsCardsValueList);

        Random rnd = new Random();
        int cpuNumOfCards = rnd.nextInt(5) + 1;

        System.out.println("交換する枚数" + cpuNumOfCards);
        //CPUの手札をランダムな枚数交換する
        HandsCards.cpuChangeCards(cpuNumOfCards, cpuHandsCardsValueList, cpusHandsCardsList);

        System.out.println("確認用" + cpusHandsCardsList);
        //CPUの手札に交換した枚数分カードを追加する
        HandsCards.getRandomCards(cardsList, cpuNumOfCards, cpusHandsCardsList);

        //交換した後の手札をプレイヤーに見せる
        HandsCards.openHandsCardValues(playersHandsCardsList);

        //確認用
        HandsCards.openHandsCardValues(cpusHandsCardsList);

        //プレイヤー,CPU手札の役を確認する
        HandsGrade playerHandsGrade = Judge.checkHands(playersHandsCardsList);
        HandsGrade cpuHandsGrade = Judge.checkHands(cpusHandsCardsList);

        String player = "プレイヤーの";
        //プレイヤーの役を公開する
        Judge.openHandsGrade(playerHandsGrade, player);

        String cpu = "cpuの";
        //CPUの役を公開する
        Judge.openHandsGrade(cpuHandsGrade, cpu);

        //プレイヤー,CPUの手札の役を比較する
        Judge.judgeHands(playerHandsGrade, cpuHandsGrade, playersHandsCardsList, cpusHandsCardsList);
    }
}
