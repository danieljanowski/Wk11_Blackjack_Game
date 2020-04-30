public class Dealer {

    private Deck deck;
    private Player player1;
    private Player player2;

    public Dealer(Deck deck, Player player1, Player player2) {
        this.deck = deck;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void dealCard(){
        Card card = this.deck.dealCard();
        this.player1.takeCard(card);
        card = this.deck.dealCard();
        this.player2.takeCard(card);
    }

}
