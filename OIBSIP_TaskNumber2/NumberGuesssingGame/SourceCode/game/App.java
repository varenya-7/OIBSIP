package game;
import java.util.Scanner;
import java.util.Random;
public class App {
    public int randomNumber;
    public int Guesses;
    public int userInput;
    public int attempts = 10;


    App() {
        Random r = new Random();
        this.randomNumber = r.nextInt(100);
    }

    public boolean isCorrectNumber() {
        Guesses++;
        attempts--;
        if (userInput == randomNumber) {
            System.out.println("\t* YOUR GUESS IS CORRECT! \n\t* NO OF GUESSES=>"+Guesses);
            System.out.println();
            return true;
        } else if (userInput > 100) {
            System.out.println("\t* Your Number is out of Range..Enter a Number between [1-100]");
            System.out.println("\t* Number of attempts left=>" + attempts);
            System.out.println();

        } else if (userInput < randomNumber) {
            System.out.println("\t* [Number is less than the Random Number]");
            System.out.println("\t* Number of attempts left=>" + attempts);
            System.out.println();
        } else if (userInput > randomNumber) {
            System.out.println("\t* [Number is Greater than the Random Number]");
            System.out.println("\t* Number of attempts left=>" + attempts);
            System.out.println();
        }

        return false;
    }

    public void UserInput() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("* Guess the Number [1-100] =>");
            userInput = sc.nextInt();
        } catch (Exception e) {
            System.out.println("\t* ENTER A WHOLE NUMBER");

        }
    }

    public static void main(String[] args) {
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        while (flag != false) {
            System.out.println("**********NUMBER GUESSING GAME**********");
            System.out.println();
            System.out.println("********YOU ONLY HAVE 10 ATTEMPTS*******");
            System.out.println();
            App a = new App();
            boolean res = false;
            while (res != true) {
                if (a.attempts <= 0) {
                    break;
                }
                a.UserInput();
                res = a.isCorrectNumber();
            }
            if (a.attempts == 0) {
                System.out.println("\tXXXXXXX YOU ARE OUT OF LIVES :( XXXXXXX");
                System.out.println();
                System.out.println();
            }
            System.out.println("******DO YOU WISH TO CONTINUE THE GAME******");
            System.out.println("\t* Press Y to Continue\n\t* Press N to Stop");
            String ch = sc.next();
            if(ch.equals("Y"))flag=true;
            else if (ch.equals("N")) {
            flag=false;
                System.out.println("***** GAME OVER *****");
            break;
            }
            System.out.println();
        }
    }
}
