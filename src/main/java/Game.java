import java.util.concurrent.TimeUnit;

public class Game {

    private Deck deck;
    private Dealer dealer;
    private Player player1;

    public Game(Deck deck,Dealer dealer , Player player) {
        this.deck = deck;
        this.dealer = dealer;
        this.player1 = player;
    }

    public void deal2Cards(){
        for (int i = 0; i < 2; i++) {
            Card card = this.deck.dealCard();
            this.dealer.takeCard(card);
            card = this.deck.dealCard();
            this.player1.takeCard(card);
        }
    }

    public boolean dealerWins() {
        if (dealer.cardsValue() > player1.cardsValue() & dealer.cardsValue() <= 21) return true;
        else if (dealer.cardsValue() == 21 & player1.cardsValue() == 21 & dealer.hasBlackjack()) return true;
        else return false;
    }

    public boolean draw(){
        if (dealer.cardsValue() == player1.cardsValue() & !dealer.hasBlackjack() & !player1.hasBlackjack()) return true;
        else return false;
    }

    public void clearCards() {
        dealer.clearCards();
        player1.clearCards();
    }

    public void dealCardToPlayer() {
        Card card = this.deck.dealCard();
        this.player1.takeCard(card);
    }

    public boolean playerBusted() {
        if (player1.cardsValue() > 21) return true;
        else return false;
    }

    public void dealerMove() throws InterruptedException {
        if (dealer.cardsValue()<16) {
            TimeUnit.SECONDS.sleep(1);
            Card card = this.deck.dealCard();
            this.dealer.takeCard(card);

            System.out.println("");

            dealer.printCards();
            player1.printCards();
        }
    }
}
