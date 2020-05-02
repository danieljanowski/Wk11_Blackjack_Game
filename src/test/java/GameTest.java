import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Deck deck;
    private Dealer dealer;
    private Player player1;
    private Game game;

    @Before
    public void before(){
        dealer = new Dealer();
        player1 = new Player("Daniel");
        deck = new Deck();
        deck.populateCards();
        deck.shuffleDeck();
        game = new Game(deck, dealer, player1);
    }

    @Test
    public void canDeal2CardsToPlayerAndDealer(){
        game.deal2Cards();
        assertEquals(48, deck.countCards());
    }

}
