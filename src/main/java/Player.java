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

                                                        //  Calculate value of hand in Blackjack
    public int cardsValue() {
        int value = 0;                                  //  start with value of hand 0
        for (Card card : this.hand) {                   //  iterate through all the cards in hand
            value += card.getValueFromCard();           //  and add value of each card to total value, ace has value 11
        }
        if (value > 21 & numberOfAces() > 0){           //  if total value of cards is more than 21
                                                        //  and if there is one or more Ace in hand
            for (int i=0; i < numberOfAces(); i++){     //  for each Ace in the hand
                value -= 10;                            //  change value of Ace from 11 to 1
                if (value <= 21) break;                 //  until hand value is less than 21 and return it
            }
        }
        return value;                                   //  if there are no aces in hand return value of hand
    }

    public int numberOfAces(){                          // Calculate number of Aces in hand
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

    public boolean hasBlackjack() {
        for (Card card : this.hand) {
            if (card.getRank() == Rank.ACE) {
                for (Card card2 : this.hand) {
                    if (card2.getRank() == Rank.KING) return true;
                }
            }
        }
        return false;
    }
}
