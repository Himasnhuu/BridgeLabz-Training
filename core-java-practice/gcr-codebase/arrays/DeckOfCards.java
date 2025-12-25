package Week_01.stringarray.level3;
import java.util.Scanner;

public class DeckOfCards {

    // Method to initialize the deck of cards
    public static String[] initializeDeck(String[] suits, String[] ranks) {
        // Calculate total number of cards (4 suits × 13 ranks = 52 cards)
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];

        // Create all card combinations
        int index = 0;
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index] = ranks[j] + " of " + suits[i];
                index++;
            }
        }
        return deck;
    }

    // Method to shuffle the deck using random swapping
    public static void shuffleDeck(String[] deck) {
        int n = deck.length;

        // Randomly swap cards to shuffle the deck
        for (int i = 0; i < n; i++) {
            // Generate random index from current position to end
            int randomCardNumber = i + (int) (Math.random() * (n - i));

            // Swap current card with random card
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
    }

    // Method to distribute cards to players
    public static String[][] distributeCards(String[] deck, int numOfPlayers, int cardsPerPlayer) {

        // Check if enough cards available
        if (numOfPlayers * cardsPerPlayer > deck.length) {
            System.out.println("Not enough cards to distribute!");
            return null;
        }

        // Create 2D array to store cards for each player
        String[][] players = new String[numOfPlayers][cardsPerPlayer];

        // Distribute cards from deck to players
        int cardIndex = 0;
        for (int i = 0; i < numOfPlayers; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                players[i][j] = deck[cardIndex];
                cardIndex++;
            }
        }
        return players;
    }

    // Method to print players and their cards
    public static void printPlayers(String[][] players) {
        // Display cards for each player
        for (int i = 0; i < players.length; i++) {
            System.out.println("\nPlayer " + (i + 1) + " cards:");
            for (int j = 0; j < players[i].length; j++) {
                System.out.println(players[i][j]);
            }
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Define card suits and ranks
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {
                "2", "3", "4", "5", "6", "7",
                "8", "9", "10", "Jack", "Queen", "King", "Ace"
        };

        // Initialize deck with all cards
        String[] deck = initializeDeck(suits, ranks);

        // Shuffle deck randomly
        shuffleDeck(deck);

        // Take user input for game setup
        System.out.print("Enter number of players: ");
        int numOfPlayers = sc.nextInt();

        System.out.print("Enter number of cards per player: ");
        int cardsPerPlayer = sc.nextInt();

        // Distribute cards to all players
        String[][] players = distributeCards(deck, numOfPlayers, cardsPerPlayer);

        // Print result if distribution successful
        if (players != null) {
            printPlayers(players);
        }

        sc.close();
    }
}