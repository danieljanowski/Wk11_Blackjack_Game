import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DeckTest {

    private Card card;
    private Deck deck;

    @Before
    public void before() {
        card = new Card(Suit.HEARTS, Rank.ACE);
        deck = new Deck();
    }

    @Test
    public void checkDeck() {
        deck.populateCards();
        assertEquals(52, deck.countCards());
    }

    @Test
    public void testShuffle() {
        deck.populateCards();
        Card card1 = deck.getCardAtIndex(0);
        deck.shuffleDeck();
        Card card2 = deck.getCardAtIndex(0);
        assertNotEquals(card1, card2);
    }

    @Test
    public void testDealCard(){
        deck.populateCards();
        deck.shuffleDeck();
        deck.dealCard();
        assertEquals(51, deck.countCards());
    }
}
