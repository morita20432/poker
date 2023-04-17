package example;

import com.example.Cards;
import com.example.HandsGrade;
import com.example.Judge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JudgeTest {

//    void checkHandsTest() {
//        List<Cards> list = List.of(Cards.CLUB_ACE,Cards.DIAMOND_ACE,Cards.CLUB_FIVE,Cards.CLUB_NINE,Cards.DIAMOND_NINE);
//        if (Judge.royalStraightFlush(list)) {
//            return HandsGrade.ROYALFLUSH;
//        } else if (Judge.straightFlush(list)) {
//            return HandsGrade.STRAIGHTFLUSH;
//        } else if (Judge.forOfAKind(list)) {
//            return HandsGrade.FOROFAKIND;
//        } else if (Judge.fullHouse(list)) {
//            return HandsGrade.FULLHOUSE;
//        } else if (Judge.flush(list)) {
//            return HandsGrade.FLUSH;
//        } else if (Judge.straight(list)) {
//            return HandsGrade.STRAIGHT;
//        } else if (Judge.threeOfAKind(list)) {
//            return HandsGrade.THREEOFAKIND;
//        } else if (Judge.twoPair(list)) {
//            return HandsGrade.TWOPAIR;
//        } else if (Judge.onePair(list)) {
//            return HandsGrade.ONEPAIR;
//        } else {
//            return HandsGrade.NOPAIR;
//        }
//
//    }

    @Test
    @DisplayName("ロイヤルストレートフラッシュな手札をロイヤルストレートフラッシュと判定できる")
    void royalStraightFlush_true() {
        assertTrue(Judge.royalStraightFlush(List.of(
                Cards.CLUB_TEN,
                Cards.CLUB_JACK,
                Cards.CLUB_QUEEN,
                Cards.CLUB_KING,
                Cards.CLUB_ACE
        )));
    }

    @Test
    @DisplayName("ロイヤルストレートフラッシュではない手札をロイヤルストレートフラッシュではないと判定できる")
    void royalStraightFlush_false() {
        assertFalse(Judge.royalStraightFlush(List.of(
                Cards.CLUB_TEN,
                Cards.CLUB_JACK,
                Cards.CLUB_QUEEN,
                Cards.CLUB_KING,
                Cards.DIAMOND_ACE
        )));
    }

    @Test
    @DisplayName("ストレートフラッシュな手札をストレートフラッシュと判定できる")
    void straightFlush_true() {
        assertTrue(Judge.straightFlush(List.of(
                Cards.CLUB_TEN,
                Cards.CLUB_JACK,
                Cards.CLUB_QUEEN,
                Cards.CLUB_KING,
                Cards.CLUB_ACE
        )));
    }

    @Test
    @DisplayName("ストレートフラッシュではない手札をストレートフラッシュではないと判定できる")
    void straightFlush_false() {
        assertFalse(Judge.straightFlush(List.of(
                Cards.CLUB_TEN,
                Cards.CLUB_JACK,
                Cards.CLUB_QUEEN,
                Cards.CLUB_KING,
                Cards.DIAMOND_ACE
        )));
    }


    @Test
    @DisplayName("フォーカードな手札をフォーカードと判定できる")
    void fourOfAKind1_true() {
        assertTrue(Judge.fourOfAKind(List.of(
                Cards.CLUB_TEN,
                Cards.DIAMOND_TEN,
                Cards.HEART_TEN,
                Cards.SPADE_TEN,
                Cards.CLUB_ACE
        )));
    }

    @Test
    @DisplayName("フォーカードな手札をフォーカードと判定できる")
    void fourOfAKind2_true() {
        assertTrue(Judge.fourOfAKind(List.of(
                Cards.CLUB_TEN,
                Cards.DIAMOND_TEN,
                Cards.HEART_TEN,
                Cards.SPADE_TEN,
                Cards.CLUB_KING
        )));
    }

    @Test
    @DisplayName("フォーカードではない手札をフォーカードではないと判定できる")
    void fourOfAKind_false() {
        assertFalse(Judge.fourOfAKind(List.of(
                Cards.CLUB_TEN,
                Cards.CLUB_JACK,
                Cards.CLUB_QUEEN,
                Cards.CLUB_KING,
                Cards.CLUB_ACE
        )));
    }

    @Test
    @DisplayName("フルハウスな手札をフルハウスと判定できる")
    void fullHouse1_true() {
        assertTrue(Judge.fullHouse(List.of(
                Cards.CLUB_TEN,
                Cards.DIAMOND_TEN,
                Cards.HEART_TEN,
                Cards.CLUB_ACE,
                Cards.DIAMOND_ACE
        )));
    }

    @Test
    @DisplayName("フルハウスな手札をフルハウスと判定できる")
    void fullHouse2_true() {
        assertTrue(Judge.fullHouse(List.of(
                Cards.CLUB_TEN,
                Cards.DIAMOND_TEN,
                Cards.HEART_ACE,
                Cards.CLUB_ACE,
                Cards.DIAMOND_ACE
        )));
    }

    @Test
    @DisplayName("フルハウスではない手札をフルハウスではないと判定できる")
    void fullHouse_false() {
        assertFalse(Judge.fullHouse(List.of(
                Cards.CLUB_TEN,
                Cards.CLUB_JACK,
                Cards.CLUB_QUEEN,
                Cards.CLUB_KING,
                Cards.CLUB_ACE
        )));
    }


    @Test
    @DisplayName("フラッシュな手札をフラッシュと判定できる")
    void flush_true() {
        assertTrue(Judge.flush(List.of(
                Cards.CLUB_TEN,
                Cards.CLUB_JACK,
                Cards.CLUB_QUEEN,
                Cards.CLUB_KING,
                Cards.CLUB_ACE
        )));
    }

    @Test
    @DisplayName("フラッシュではない手札をフラッシュではないと判定できる")
    void flush_false() {
        assertFalse(Judge.flush(List.of(
                Cards.CLUB_TEN,
                Cards.CLUB_JACK,
                Cards.CLUB_QUEEN,
                Cards.CLUB_KING,
                Cards.DIAMOND_ACE
        )));
    }

    @Test
    @DisplayName("ストレートで10,11,12,13,1の手札をストレートと判定できる")
    void straight_royal_true() {
        assertTrue(Judge.straight(List.of(
                Cards.CLUB_TEN,
                Cards.CLUB_JACK,
                Cards.CLUB_QUEEN,
                Cards.CLUB_KING,
                Cards.CLUB_ACE
        )));
    }

    @Test
    @DisplayName("ストレート(10,11,12,13,1以外)な手札をストレートと判定できる")
    void straight_true() {
        assertTrue(Judge.straight(List.of(
                Cards.CLUB_FOUR,
                Cards.CLUB_FIVE,
                Cards.CLUB_SEVEN,
                Cards.CLUB_SIX,
                Cards.CLUB_EIGHT
        )));
    }


    @Test
    @DisplayName("ストレートではない手札をストレートではないと判定できる")
    void straight_false() {
        assertFalse(Judge.straight(List.of(
                Cards.CLUB_TEN,
                Cards.CLUB_JACK,
                Cards.CLUB_QUEEN,
                Cards.CLUB_KING,
                Cards.DIAMOND_FIVE
        )));
    }

    @Test
    @DisplayName("スリーカードな手札をスリーカードと判定できる")
    void threeOfAKind1_true() {
        assertTrue(Judge.threeOfAKind(List.of(
                Cards.CLUB_TEN,
                Cards.DIAMOND_TEN,
                Cards.HEART_TEN,
                Cards.SPADE_NINE,
                Cards.CLUB_ACE
        )));
    }

    @Test
    @DisplayName("スリーカードな手札をスリーカードと判定できる")
    void threeOfAKind2_true() {
        assertTrue(Judge.threeOfAKind(List.of(
                Cards.CLUB_TEN,
                Cards.DIAMOND_EIGHT,
                Cards.HEART_ACE,
                Cards.SPADE_ACE,
                Cards.CLUB_ACE
        )));
    }

    @Test
    @DisplayName("スリーカードな手札をスリーカードと判定できる")
    void threeOfAKind3_true() {
        assertTrue(Judge.threeOfAKind(List.of(
                Cards.CLUB_TEN,
                Cards.DIAMOND_NINE,
                Cards.HEART_NINE,
                Cards.SPADE_NINE,
                Cards.CLUB_ACE
        )));
    }

    @Test
    @DisplayName("スリーカードではない手札をスリーカードではないと判定できる")
    void threeOfAKind_false() {
        assertFalse(Judge.threeOfAKind(List.of(
                Cards.CLUB_TEN,
                Cards.DIAMOND_TEN,
                Cards.CLUB_QUEEN,
                Cards.CLUB_KING,
                Cards.CLUB_ACE
        )));
    }

    @Test
    @DisplayName("ツーペアな手札をツーペアと判定できる")
    void twoPair1_true() {
        assertTrue(Judge.twoPair(List.of(
                Cards.CLUB_TEN,
                Cards.DIAMOND_TEN,
                Cards.CLUB_QUEEN,
                Cards.SPADE_ACE,
                Cards.CLUB_ACE
        )));
    }

    @Test
    @DisplayName("ツーペアな手札をツーペアと判定できる")
    void twoPair2_true() {
        assertTrue(Judge.twoPair(List.of(
                Cards.CLUB_TEN,
                Cards.DIAMOND_TEN,
                Cards.CLUB_QUEEN,
                Cards.HEART_QUEEN,
                Cards.CLUB_ACE
        )));
    }

    @Test
    @DisplayName("ツーペアな手札をツーペアと判定できる")
    void twoPair3_true() {
        assertTrue(Judge.twoPair(List.of(
                Cards.CLUB_TEN,
                Cards.CLUB_JACK,
                Cards.DIAMOND_JACK,
                Cards.SPADE_ACE,
                Cards.CLUB_ACE
        )));
    }

    @Test
    @DisplayName("ツーペアではない手札をツーペアではないと判定できる")
    void twoPair_false() {
        assertFalse(Judge.twoPair(List.of(
                Cards.CLUB_TEN,
                Cards.CLUB_JACK,
                Cards.CLUB_QUEEN,
                Cards.CLUB_KING,
                Cards.CLUB_ACE
        )));
    }

    @Test
    @DisplayName("ワンペアな手札をワンペアと判定できる")
    void onePair_true1() {
        assertTrue(Judge.onePair(List.of(
                Cards.CLUB_TEN,
                Cards.DIAMOND_TEN,
                Cards.CLUB_QUEEN,
                Cards.CLUB_KING,
                Cards.CLUB_ACE
        )));
    }

    @Test
    @DisplayName("ワンペアな手札をワンペアと判定できる")
    void onePair_true2() {
        assertTrue(Judge.onePair(List.of(
                Cards.CLUB_TEN,
                Cards.DIAMOND_QUEEN,
                Cards.CLUB_QUEEN,
                Cards.CLUB_KING,
                Cards.CLUB_ACE
        )));
    }

    @Test
    @DisplayName("ワンペアな手札をワンペアと判定できる")
    void onePair_true3() {
        assertTrue(Judge.onePair(List.of(
                Cards.CLUB_TEN,
                Cards.CLUB_JACK,
                Cards.DIAMOND_KING,
                Cards.CLUB_KING,
                Cards.CLUB_ACE
        )));
    }

    @Test
    @DisplayName("ワンペアな手札をワンペアと判定できる")
    void onePair_true4() {
        assertTrue(Judge.onePair(List.of(
                Cards.CLUB_TEN,
                Cards.DIAMOND_TEN,
                Cards.CLUB_QUEEN,
                Cards.SPADE_ACE,
                Cards.CLUB_ACE
        )));
    }

    @Test
    @DisplayName("ワンペアではない手札をワンペアではないと判定できる")
    void onePair_false() {
        assertFalse(Judge.onePair(List.of(
                Cards.CLUB_TEN,
                Cards.CLUB_JACK,
                Cards.CLUB_QUEEN,
                Cards.CLUB_KING,
                Cards.CLUB_ACE
        )));
    }

}
