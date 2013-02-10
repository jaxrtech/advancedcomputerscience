import java.awt.*;
import java.util.Scanner;

/**
 * Class for simple testing
 * <p/>
 * Copyright Georgia Institute of Technology 2004
 *
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public class GuessGame {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = (int) (Math.random() * 5 + 1);
        System.out.println("Guess a number between 1 and 5");
        int guess = s.nextInt();
        if (guess == num) {
            System.out.println("You are amazing!");
        } else {
            System.out.println("You are not a very good guesser!");
        }
    }
}