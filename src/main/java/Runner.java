import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deck deck;
        Dealer dealer;
        Player player1;
        Game game;
        String repeatGame;

        dealer = new Dealer();
        player1 = new Player("Daniel");
        deck = new Deck();
        deck.populateCards();
        deck.shuffleDeck();
        game = new Game(deck, dealer, player1);
        repeatGame = "y";

        System.out.println("Welcome!");

        while (repeatGame == ("y")) {
            game.clearCards();
            game.deal2Cards();

            player1.printCards();
            dealer.printCards();

            if (game.dealerWins()) System.out.println("Dealer wins!");
            else if (!game.dealerWins() & !game.draw()) System.out.println("Player wins!");
            else if (game.draw()) System.out.println("Draw!");
            else System.out.println("Whaaaat?!");

            System.out.print("Would you like to play again? (y/n) ");
            repeatGame = scanner.nextLine();
        }

      }
    }
