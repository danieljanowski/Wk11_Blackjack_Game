import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    private Dealer dealer;
    private Deck deck;
    private Player player1;

    @Before
    public void before(){
        player1 = new Player("Daniel");
        deck = new Deck();
        deck.populateCards();
        deck.shuffleDeck();
        dealer = new Dealer();
    }

    @Test
    public void dealerCanTakeCard(){
        Card card = deck.dealCard();
        dealer.takeCard(card);
        assertEquals(1, dealer.cardsCount());
    }

}
