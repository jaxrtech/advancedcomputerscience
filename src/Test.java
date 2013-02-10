import java.awt.*;
import java.util.Scanner;

/**
 * Class for simple testing
 * <p/>
 * Copyright Georgia Institute of Technology 2004
 *
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public class Test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Choose 1, 2 or 3");
        int num = s.nextInt();
        if (num == 1) {
            MidiPlayer player = new MidiPlayer();
            player.setInstrument(MidiPlayer.FLUTE);
            World w = new World();
            String fname = "X:/1McDaniel/Media Comp/mediasources/turtle.jpg";
            Picture p = new Picture(fname);
            w.setPicture(p);
            Turtle t = new Turtle(100, 100, w);

            t.forward(300);
            player.playNote(80, 1250);
            t.turn(40);
            t.forward(100);
            t.setColor(Color.yellow);
            player.playNote(60, 1250);
            t.turn(90);
            t.forward(10);
            player.playNote(40, 1250);

            t.turn(40);
            t.forward(330);
            player.playNote(40, 1250);
            t.turn(-40);
            t.forward(500);
            t.setColor(Color.red);
            player.playNote(80, 1250);

            t.turn(-90);
            t.forward(440);
            player.playNote(60, 1250);

            t.turn(-90);
            t.forward(440);
            player.playNote(60, 1250);

            t.turn(-90);
            t.forward(440);
            player.playNote(60, 1250);
        } else if (num == 2) {
            System.out.println("Wesleyan is the best school for sports in Georgia!");
        } else
            System.out.println("I love computers!");
    }
} // end of Test class