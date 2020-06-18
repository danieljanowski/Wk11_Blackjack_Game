import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Runner {

    public static void main(String[] args) throws InterruptedException, IOException {

        Scanner scanner = new Scanner(System.in);

        Deck deck;
        Dealer dealer;
        Player player1;
        Game game;
        int repeatGame;
        int choice;

        dealer = new Dealer();
        player1 = new Player("Daniel");
        deck = new Deck();
        deck.populateCards();
        deck.shuffleDeck();
        game = new Game(deck, dealer, player1);
        repeatGame = 1;
        choice = 1;

        System.out.println("Welcome!");

        while (repeatGame == 1) {
            game.clearCards();
            game.deal2Cards();
            choice = 1;

            System.out.println("");
            dealer.showFirstCard();
            player1.printCards();
//            dealer.printCards();


            //Player
            while (choice == 1) {
                System.out.print("Twist (1) or Stick(0)? (1/0) ");
                choice = scanner.nextInt();
                if (choice == 1) {
                    game.dealCardToPlayer();

                    System.out.println("");
                    dealer.showFirstCard();
                    player1.printCards();
                    if (game.playerBusted()) {
                        System.out.println("Dealer wins!");
                        break;
                    }
                }
            }
            //Dealer
            if (choice == 0) {
                System.out.println("");
                dealer.printCards();
                player1.printCards();
                game.dealerMove();

                TimeUnit.SECONDS.sleep(1);
                System.out.println("");

                if (game.dealerWins()) System.out.println("Dealer wins!");
                else if (!game.dealerWins() & !game.draw()) System.out.println("Player wins!");
                else if (game.draw()) System.out.println("Draw!");
            }

            System.out.print("Would you like to play again? (1/0) ");
            repeatGame = scanner.nextInt();
        }
    }
}
