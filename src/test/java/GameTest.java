import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Deck deck;
    private Dealer dealer;
    private Player player1;
    private Game game;
    private Card card1;
    private Card card2;
    private Card card3;
    private Card card4;

    @Before
    public void before(){
        dealer = new Dealer();
        player1 = new Player("Daniel");
        deck = new Deck();
        deck.populateCards();
        deck.shuffleDeck();
        game = new Game(deck, dealer, player1);
        card1 = new Card(Suit.SPADES, Rank.SEVEN);
        card2 = new Card(Suit.DIAMONDS, Rank.TWO);
        card3 = new Card(Suit.SPADES, Rank.EIGHT);
        card4 = new Card(Suit.DIAMONDS, Rank.KING);
    }

    @Test
    public void canDeal2CardsToPlayerAndDealer(){
        game.deal2Cards();
        assertEquals(48, deck.countCards());
        assertEquals(2, player1.cardsCount());
        assertEquals(2, dealer.cardsCount());
    }

    @Test
    public void dealerWins(){
        player1.takeCard(card1);
        player1.takeCard(card2);
        dealer.takeCard(card3);
        dealer.takeCard(card4);
        assertEquals(true, game.dealerWins());
        assertEquals(false, game.draw());
    }

    @Test
    public void playerWins(){
        player1.takeCard(card3);
        player1.takeCard(card4);
        dealer.takeCard(card1);
        dealer.takeCard(card2);
        assertEquals(false, game.dealerWins());
        assertEquals(false, game.draw());
    }

    @Test
    public void draw(){
        player1.takeCard(card1);
        player1.takeCard(card2);
        dealer.takeCard(card1);
        dealer.takeCard(card2);
        assertEquals(false, game.dealerWins());
        assertEquals(true, game.draw());
    }
}
