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
        System.out.print("Dealer");
        for (Card card : this.hand) {
            System.out.print(": " + card.getRank() + " " + card.getSuit());
        }
        System.out.println(" - " + cardsValue() + " points");
    }

    public void showFirstCard(){
        System.out.print("Dealer");
        Card card = this.hand.get(0);
        System.out.print(": " + card.getRank() + " " + card.getSuit());
        System.out.println(" - " + card.getValueFromCard() + " points");
    }

    public void clearCards() {
        this.hand.clear();
    }
}
