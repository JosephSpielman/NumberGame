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
        String gameStart = "Lets play Guess the Number!+\n" +
                "I am thinking of a number from 1-20, can you guess it in 6 tries or less?";
        String newGame = "";
        boolean keepPlaying = true;


        //start display info.
        System.out.print("Welcome! ");
        playerName = getPlayerName(sc);
        System.out.println("Ok " + playerName + " lets start the game.");
        //start overall game loop.
        while (keepPlaying) {
            //generate random number 1-20 for computer.
            compNum = rnd.nextInt(19) + 1;
            //start for loop to count turns.
            for (int x = 1; x <= 6; x++) {
                //call playerGuess method to receive and validate input.
                playerGuess = getPlayerGuess(sc, x);
                //compare input with generated number
                if(playerGuess == compNum){
                    System.out.println("Good job "+playerName+"! You got right in "+x+" turn(s).");
                    break;
                }else{
                    //Input was incorrect, determine if it was too high or low and display correct message.
                    incorrectMessage(compNum,playerGuess);
                }
            }
            //get user input and determine if a new game should start.
            keepPlaying = continuePlaying(sc);
        }
        System.out.print("Thanks for playing!");
    }

    //validate that name input is present.
    public static String getPlayerName(Scanner sc) {
        boolean check = true;
        String name = null;
        while (check) {
            System.out.println("Enter your name:");
            name = sc.nextLine();
            if (!name.isEmpty()) {
                check = false;
            } else {
                System.out.println("Aww don't be shy.");
            }
        }
        return name;
    }

    //read input for player guess, validate that it is an integer and return.
    public static int getPlayerGuess(Scanner sc,int counter){
        boolean check = true;
        boolean validEntry = false;

        String input = null;
        int guess = 0;

        while(check){
            System.out.println("Turn:"+counter+" Guess a number:");
            input = sc.nextLine();

            if(!input.isEmpty()){
                try {
                    guess = Integer.parseInt(input);
                    check =false;
                }catch(Exception e){
                    System.out.println("Invalid entry! Please guess an Integer");
                }
            }
        }
        return guess;
    }
    //determine if player guess was too high or low.
    public static void incorrectMessage(int comp,int player){
        if(comp > player){
            System.out.println("Your guess was too low.");
        }else{
            System.out.println("Your guess was too high.");
        }
    }
    //read user input for a new game. Validate that input is present and is either 'y'or 'n'. Return decision.
    public static boolean continuePlaying(Scanner sc) {

        String input = null;
        boolean newGame = false;
        boolean check = true;

        while (check) {
            System.out.println("Would you like to play again? y/n");
            input = sc.nextLine();
            if (!input.isEmpty()) {
                if (input.equalsIgnoreCase("n")) {
                    check = false;
                    newGame = false;
                } else if (input.equalsIgnoreCase("y")) {
                    newGame = true;
                    check = false;
                }
            } else {
                System.out.println("Invalid entry! Please type y or n");
            }
        }
        return newGame;
    }
}

