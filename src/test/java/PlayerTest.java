import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Deck deck;
    private Player player1;
    private Card card1;
    private Card card2;
    private Card card3;
    private Card card4;


    @Before
    public void before() {
        deck = new Deck();
        deck.populateCards();
        deck.shuffleDeck();
        player1 = new Player("Daniel");
        card1 = new Card(Suit.SPADES, Rank.EIGHT);
        card2 = new Card(Suit.DIAMONDS, Rank.KING);
        card3 = new Card(Suit.HEARTS, Rank.ACE);
        card4 = new Card(Suit.CLUBS, Rank.ACE);
    }

    @Test
    public void playerCanTakeCard(){
        Card card = deck.dealCard();
        player1.takeCard(card);
        assertEquals(1, player1.cardsCount());
    }

    @Test
    public void ableToReturnCardValues(){
        player1.takeCard(card1);
        player1.takeCard(card2);
        assertEquals(18, player1.cardsValue());
        player1.takeCard(card3);
        assertEquals(19, player1.cardsValue());
        player1.takeCard(card4);
        assertEquals(20, player1.cardsValue());

    }

    @Test
    public void ableToClearCards(){
        player1.takeCard(card1);
        player1.takeCard(card2);
        assertEquals(2, player1.cardsCount());
        player1.clearCards();
        assertEquals(0, player1.cardsCount());
    }

    @Test
    public void canCountAces(){
        player1.takeCard(card3);
        assertEquals(1, player1.numberOfAces());
        player1.takeCard(card4);
        assertEquals(2, player1.numberOfAces());
    }

    @Test
    public void hasBlackjack(){
        player1.takeCard(card1);
        player1.takeCard(card2);
        player1.takeCard(card3);
        player1.takeCard(card4);
        assertEquals(true, player1.hasBlackjack());
    }

    @Test
    public void doesntHaveBlackjack(){
        player1.takeCard(card1);
        player1.takeCard(card4);
        assertEquals(false, player1.hasBlackjack());
    }

}
