import java.util.Scanner;

public class Decision {

    public static boolean continuePlaying(String input) {
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        boolean out = false;

        while (check) {
            if (!input.equals("")) {
                if (input.equalsIgnoreCase("n")) {
                    check = false;
                } else if (input.equalsIgnoreCase("y")) {
                    out = true;
                    check = false;

                } else {
                    System.out.println("Invalid entry! Please enter y or n.");
                    input = sc.nextLine();
                }
            }else{
                System.out.println("Invalid entry! Please enter y or n.");
                input = sc.nextLine();
            }
        }
        return out;
    }

    public static String incorrectMessage(int comp,int player){
        if(comp > player){
            return "Your guess was too low.";
        }else{
            return "Your guess was too high.";
        }
    }

    public static String getPlayerName(String input) {
        boolean check = true;
        String name = null;
        Scanner sc = new Scanner(System.in);
        while (check)
            try {
                System.out.println("Enter your name:");
                name = sc.nextLine();
                if (!name.isEmpty()) {
                    check = false;
                }
            }
            catch(Exception e){
                break;
            }
        return name;
    }

    public static int getPlayerGuess(int counter){
        boolean check = true;
        Scanner sc = new Scanner(System.in);
        int guess = 0;

        while(check){
            System.out.println("Turn:"+counter+" Guess a number:");
            String input = sc.nextLine();
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
}
