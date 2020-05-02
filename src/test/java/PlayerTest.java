import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Deck deck;
    private Player player1;
    private Card card1;
    private Card card2;


    @Before
    public void before() {
        deck = new Deck();
        deck.populateCards();
        deck.shuffleDeck();
        player1 = new Player("Daniel");
        card1 = new Card(Suit.SPADES, Rank.EIGHT);
        card2 = new Card(Suit.DIAMONDS, Rank.KING);
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
    }

}
