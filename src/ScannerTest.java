import java.util.*;
import java.awt.*;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Do you want to see a picture?");
        String answer = s.nextLine();   //get the user's answer
        if (answer.equals("yes")) {
            World w = new World(500, 500);
            String fname = "X:/1McDaniel/Media Comp/mediasources/temple.jpg";
            Picture p = new Picture(fname);
            w.setPicture(p);
            Turtle t = new Turtle(w);
            t.setColor(Color.black);
            Random r = new Random();
            int myNum = r.nextInt(100);  //generates a random num from 0 to 99
            t.forward(myNum);

            for (int i = 0; i <= 3200000; i++) ;  //pause
            t.clearPath();
        }


    }
}                       
                  
                     
