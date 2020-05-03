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
        if (value > 21 & numberOfAces() > 0){
            for (int i=0; i < numberOfAces(); i++){
                value -= 10;
                if (value <= 21) break;
            }
        }
        return value;
    }

    public int numberOfAces(){
        int value = 0;
        for (Card card : this.hand) {
            if (card.getRank() == Rank.ACE) value++;
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

    public void clearCards() {
        this.hand.clear();
    }
}
