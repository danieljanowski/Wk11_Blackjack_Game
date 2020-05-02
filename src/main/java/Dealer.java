import java.util.ArrayList;

public class Dealer {

//    private Deck deck;
//    private Player player1;
    private ArrayList<Card> hand;

//    private Player player2;


    public Dealer() {
//        this.deck = deck;
//        this.player1 = player1;
        this.hand = new ArrayList<Card>();
//        this.player2 = player2;
    }

    public int cardsCount(){
        return hand.size();
    }

    public void takeCard(Card card) {
        this.hand.add(card);
    }

}
