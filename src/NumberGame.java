import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        //declarations
        Random rnd = new Random();
        int compNum = 0;
        String playerName = "";
        int playerGuess = 0;
        Scanner sc = new Scanner(System.in);
        String gameStart = "Lets play Guess the Number!\n" +
                "I am thinking of a number from 1-20, can you guess it in 6 tries or less?";
        boolean keepPlaying = true;

        //start display info.
        System.out.print("Welcome! ");
        //playerName = getPlayerName(sc);
        playerName = Decision.getPlayerName("");
        System.out.println(gameStart);
        System.out.println("\nOk " + playerName + " lets start the game.");
        //start overall game loop.
        while (keepPlaying) {
            //generate random number 1-20 for computer.
            compNum = rnd.nextInt(19) + 1;
            //start for loop to count turns.
            for (int x = 1; x <= 6; x++) {
                //call playerGuess method to receive and validate input.
                playerGuess = Decision.getPlayerGuess(x);
                //compare input with generated number
                if (playerGuess == compNum) {
                    System.out.println("Good job " + playerName + "! You got right in " + x + " turn(s).");
                    break;
                } else {
                    //Input was incorrect, determine if it was too high or low and display correct message.
                    System.out.println(Decision.incorrectMessage(compNum, playerGuess));
                }
            }
            //get user input and determine if a new game should start.
            try {
                System.out.println("Would you like to play again?");
                String answer = sc.nextLine();
                keepPlaying = Decision.continuePlaying(answer);
            } catch (Exception e) {
                System.out.println("Error!");
                keepPlaying = false;
            }
        }
        System.out.print("Thanks for playing!");
    }

}

