package com.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //52枚のカードのリストを生成
        List<Cards> cardsList = Cards.createCardsList();

        //52枚からランダムに5枚選択し、ArrayListに格納する
        List<Cards> playersHandsCardsList = new ArrayList<>(); //プレイヤーの手札を生成
        GetRandomCards.getRandomCards(cardsList, 5, playersHandsCardsList); //cardsListは47枚になる。
        System.out.println(playersHandsCardsList);
        System.out.println(cardsList.size());
        //47枚からランダムに5枚選択し、ArrayListに格納する
        List<Cards> cpusHandsCardsList = new ArrayList<>(); //cpuの手札を生成
        GetRandomCards.getRandomCards(cardsList, 5, cpusHandsCardsList); //cardsListは42枚になる。
        System.out.println(cpusHandsCardsList);
        System.out.println(cardsList.size());

        //todo プレイヤーにランダム抽出された5枚のカードを表示させる

        //todo 5枚のカードのうち、変えたいカードを選択させる

        //todo 選択した数ぶん、変えたいカードを手札から削除する。

        //todo 選択した数ぶん、山札からランダムに選んだカードを追加する
        GetRandomCards.getRandomCards(cardsList, 1, playersHandsCardsList); // todo drawCardに選択したカードの枚数を保持した変数を入れる
        GetRandomCards.getRandomCards(cardsList, 1, cpusHandsCardsList); // todo drawCardに選択したカードの枚数を保持した変数を入れる

    }
}
