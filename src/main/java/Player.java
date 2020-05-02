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

    public int cardsValue() {
        int value = 0;
        for (Card card : this.hand) {
            value += card.getValueFromCard();
        }
        return value;
    }

    public void printCards() {
        System.out.print("Player");
        for (Card card : this.hand) {
            System.out.print(": " + card.getRank() + " " + card.getSuit());
        }
        System.out.println(" - " + cardsValue() + " points");
    }
}
