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

}
