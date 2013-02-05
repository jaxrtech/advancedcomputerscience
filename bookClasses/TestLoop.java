import java.awt.Color;

public class TestLoop 
{
    public static void main (String[] args) 
    {
        String path = "H:\\ben.jpg";
        Picture picture = new Picture(path);
        picture.show();
        
        for (int x = 10; x < 200; x++)
        {
            picture.getPixel(x,100).setColor(Color.red);
        }
        
        for (int y = 20; y < 300; y++)
        {
            picture.getPixel(100,y).setColor(Color.red);
        }
        
        picture.repaint();
        
        for (int i = 12; i >= 9; i--)
        {
            System.out.println(i + "th grade");
            System.out.println("I love that grade");
        }
  
        for (int i = 1; i <= 3; i++)
            System.out.println("Goodbye");
    }
}