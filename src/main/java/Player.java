import java.sql.Array;
import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> hand;

    public Player(String name) {
        this.hand = new ArrayList<Card>();
        this.name = name;
    }

    public int cardsCount(){
        return hand.size();
    }

    public void takeCard(Card card) {
        this.hand.add(card);
    }
}
