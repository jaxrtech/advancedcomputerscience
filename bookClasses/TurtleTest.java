import java.awt.Color;

public class TurtleTest
{
    public static void main(String[] args)
    {
        World w = new World(600, 600);              
        Turtle t = new Turtle(20, 400, w);
        
        t.setColor(Color.magenta);
        t.drawCircleSpiral(20, 10);
        
        t.penUpAndDownTo(300, 300);
        t.setColor(Color.cyan);
        t.drawCircleSpiral(20, 5);
    }
}