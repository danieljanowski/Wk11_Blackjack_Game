public class Runner {

    public static void main(String[] args) {

        Deck deck;
        Dealer dealer;
        Player player1;
        Game game;

        dealer = new Dealer();
        player1 = new Player("Daniel");
        deck = new Deck();
        deck.populateCards();
        deck.shuffleDeck();
        game = new Game(deck, dealer, player1);

        System.out.println("Welcome!");

        game.deal2Cards();

        dealer.printCards();
        player1.printCards();

        if (game.dealerWins()) System.out.println("Dealer wins!");
        else if (!game.dealerWins() & !game.draw()) System.out.println("Player wins!");
        else if (game.draw()) System.out.println("Draw!");
        else System.out.println("Whaaaat?!");

    }

}
