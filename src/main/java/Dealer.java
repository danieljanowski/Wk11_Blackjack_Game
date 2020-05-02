import java.util.ArrayList;

public class Dealer {

    private ArrayList<Card> hand;

    public Dealer() {
        this.hand = new ArrayList<Card>();
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
        System.out.print("Dealer");
        for (Card card : this.hand) {
            System.out.print(": " + card.getRank() + " " + card.getSuit());
        }
        System.out.println(" - " + cardsValue() + " points");
    }

    public void clearCards() {
        this.hand.clear();
    }
}
