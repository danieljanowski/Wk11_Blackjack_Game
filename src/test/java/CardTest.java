import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {

    private Card card;

    @Before
    public void before(){
        card = new Card(Suit.DIAMONDS, Rank.KING);
    }

    @Test
    public void canGetSuit(){
        assertEquals(Suit.DIAMONDS, card.getSuit());
    }

    @Test
    public void canGetRank(){
        assertEquals(Rank.KING, card.getRank());
    }

    @Test
    public void canGetValueFromCard(){
        assertEquals(10, card.getValueFromCard());
    }

}
