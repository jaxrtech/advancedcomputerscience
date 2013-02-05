import java.awt.Color;

public class TurtleTest
{
    public static void main(String[] args)
    {
        World w = new World(600, 600);              
        Turtle t = new Turtle(200, 200, w);
        
        //t.drawFace(Color.magenta);
        t.drawDesign(Color.magenta, Color.red);
    }
}