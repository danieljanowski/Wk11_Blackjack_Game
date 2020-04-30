import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cardDeck;
    private ArrayList<Card> shuffledDeck;
    private Suit suit;
    private Rank rank;

    public Deck() {

        this.cardDeck = new ArrayList<Card>();
        this.shuffledDeck = new ArrayList<Card>();
        this.rank = rank;
        this.suit = suit;
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
        this.populateCards();
        this.shuffleDeck();
        Card card = cardDeck.get(0);
        cardDeck.remove(0);
        System.out.println(card.getRank());
        System.out.println(card.getSuit());
        return card;
    }

}
