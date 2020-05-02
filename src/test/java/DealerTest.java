import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    private Dealer dealer;
    private Deck deck;
    private Player player1;
    private Card card1;
    private Card card2;

    @Before
    public void before(){
        player1 = new Player("Daniel");
        deck = new Deck();
        deck.populateCards();
        deck.shuffleDeck();
        dealer = new Dealer();
        card1 = new Card(Suit.SPADES, Rank.SEVEN);
        card2 = new Card(Suit.DIAMONDS, Rank.TWO);
    }

    @Test
    public void dealerCanTakeCard(){
        Card card = deck.dealCard();
        dealer.takeCard(card);
        assertEquals(1, dealer.cardsCount());
    }

    @Test
    public void ableToReturnCardValues(){
        dealer.takeCard(card1);
        dealer.takeCard(card2);
        assertEquals(9, dealer.cardsValue());
    }

}
