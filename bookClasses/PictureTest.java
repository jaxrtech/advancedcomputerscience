//Linda McDaniel
import java.util.Scanner;
public class PictureTest
{
  public static void main(String[] args)
  {
   
    System.out.println("Do you want to see a car (1) or a cat (2)?");
    String f1 = "H:/car.jpg";
    Picture p = new Picture(f1);
    String f2 = "H:/kitty.jpg";
    Picture p2 = new Picture(f2);
    Scanner s = new Scanner(System.in);
    int choice = s.nextInt();
    if (choice==1)
         p.show();
    if (choice == 2)
         p2.show();
    
//    p.show();
//    p.turnBrownIntoRed();
//    p.show();

    
  }
}