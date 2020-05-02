import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Deck deck;
    private Player player1;

    @Before
    public void before() {
        deck = new Deck();
        deck.populateCards();
        deck.shuffleDeck();
        player1 = new Player("Daniel");
    }

    @Test
    public void playerCanTakeCard(){
        Card card = deck.dealCard();
        player1.takeCard(card);
        assertEquals(1, player1.cardsCount());
    }

}
