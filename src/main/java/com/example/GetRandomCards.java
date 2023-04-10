package com.example;

import java.util.List;
import java.util.Random;

public class GetRandomCards {

    //配列ではなくリスト型にした理由 = 元々の要素数や値が変化することはないが、ポーカーを進行する上で山札は減っていくため
//    public static List<Cards> getRandomFiveCards(List<Cards> cardsList) {
//        List<Cards> fiveCardsList = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            Random random = new Random();
//            int index = random.nextInt(cardsList.size());
//            Cards card = cardsList.get(index);
//            fiveCardsList.add(card);
//            cardsList.remove(index);
//        }
//        return fiveCardsList; //ランダムに選択された5枚のカードのリストが返される
//    }

    public static void getRandomCards(List<Cards> cardsList, int drawCard, List<Cards> handsCard) {

        for (int i = 0; i < drawCard; i++) {
            Random random = new Random();
            int index = random.nextInt(cardsList.size());
            Cards card = cardsList.get(index);
            handsCard.add(card);
            cardsList.remove(index);
        }

    }

}
