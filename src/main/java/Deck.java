import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cardDeck;

    public Deck() {
        this.cardDeck = new ArrayList<Card>();
    }

    public void populateCards(){
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()){
                Card card1 = new Card(suit, rank);
               this.cardDeck.add(card1);
            }
        }
    }

    public int countCards() {
        return this.cardDeck.size();
    }

    public void shuffleDeck(){
        Collections.shuffle(cardDeck);
    }

    public Card getCardAtIndex(int index) {
        return cardDeck.get(index);
    }

    public Card dealCard(){
        Card card = cardDeck.get(0);
        cardDeck.remove(0);
        return card;
    }

}
