import java.awt.*;
import java.util.Scanner;
/**
 * Class for simple testing
 * 
 * Copyright Georgia Institute of Technology 2004
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public class NumberGuess 
{
  public static void main (String[] args) 
  {
       Scanner s = new Scanner(System.in);
       int mynum = (int)(Math.random() * 5 + 1);  
       System.out.println("Guess a number between 1 and 5");  
       int guess = s.nextInt();
       if (guess == mynum) 
       {
         System.out.println("You are right!");
       }
       else
       {
          System.out.println("You are wrong!");
       }
  }
}