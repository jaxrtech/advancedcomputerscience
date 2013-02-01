//Linda McDaniel
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.text.*;

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
 public void decreaseRed()
 {
   Pixel[] pixelArray = this.getPixels();
   int value = 0;

   for(Pixel px : pixelArray)
   {
     value = px.getRed();
     value = (int) (value * 0.5);
     px.setRed(value);
   }
 }
 public void decreaseBlue()
 {
   Pixel[] pixelArray = this.getPixels();
   int value = 0;

   for(Pixel px : pixelArray)
   {
     value = px.getBlue();
     value = (int) (value * 0.5);
     px.setBlue(value);
   }
 }
 public void makeSunset(double amountBlue, double amountGreen, int start, int stop)
 {
   Pixel[] pixelArray = this.getPixels();
   Pixel pixel = null;
   int value = 0;
   int i = start;

   while (i < stop)
   {
     pixel = pixelArray[i];
     value = pixel.getBlue();
     value = (int) (value * amountBlue);
     value = pixel.getGreen();
     value = (int) (value * amountGreen);
     pixel.setGreen(value);
     i++;
   }
 }
 public void lighten()
 {
   Pixel[] pixelArray = this.getPixels();
   Color color = null;
   Pixel pixel = null;
   for (int i = 0; i < pixelArray.length; i++)
   {
     pixel = pixelArray[i];
     color = pixel.getColor();
     color = color.brighter();
     pixel.setColor(color);
   }
 }
public void mirrorTemple()
{
  int mirrorPoint = 276;
  Pixel leftPixel = null;
  Pixel rightPixel = null;
  for (int y = 27; y < 137; y++)
  {
       for (int x = 13; x < mirrorPoint; x++)
      {
         leftPixel = getPixel(x,y);
         rightPixel = getPixel(mirrorPoint + (mirrorPoint - x),y);
         rightPixel.setColor(leftPixel.getColor());
      }
   }
}
public void copy(Picture p, int startx, int width, int starty, int length,int placex, int placey)
{
    Pixel sourcePixel;
    Pixel targetPixel;
    Color white = new Color(255,255,255);
    for (int sourceX = startx, targetX = placex; sourceX < startx + width;
                sourceX++, targetX++)
    {
       for (int sourceY = starty, targetY = placey; sourceY < starty + length;
                 sourceY++, targetY++)
       {   
         sourcePixel = p.getPixel(sourceX, sourceY);
         targetPixel = this.getPixel(targetX, targetY);
         if (sourcePixel.colorDistance(white) > 20.0)
           targetPixel.setColor(sourcePixel.getColor());
       }
    }
}
  
public void negate()
{
  Pixel[] pixelArray = this.getPixels();

  Pixel pixel = null;
   int redValue, blueValue, greenValue = 0;
  for (int i = 0; i < pixelArray.length; i++)
     {
       pixel = pixelArray[i];
       redValue = pixel.getRed();
       greenValue = pixel.getGreen();
       blueValue = pixel.getBlue();
       pixel.setColor(new Color(200 - redValue,200 - greenValue, 255 - blueValue ));
     }
}

public void mirrorVertical()
{
   int width = this.getWidth();
   int mirrorPoint = width/2;
   Pixel leftPixel = null;
     Pixel rightPixel = null;
     for (int y = 0; y < getHeight(); y++)
     {
       for (int x = 0; x < mirrorPoint; x++)
       {
           leftPixel = getPixel(x, y);
           rightPixel = getPixel(width - 1 - x, y);
           leftPixel.setColor(rightPixel.getColor());
       }
     }
}  
public void copyPictureMidway()
{
  String sourceFile = "X:/1McDaniel/Media Comp/mediasources/kitten2.jpg";
  Picture sourcePicture = new Picture(sourceFile);
  sourcePicture.show();
  Pixel sourcePixel = null;
  Pixel targetPixel = null;
  for (int sourceX = 0, targetX=10; sourceX < sourcePicture.getWidth();
       sourceX++, targetX++)
  {
      for (int sourceY = 0, targetY = 10; sourceY < sourcePicture.getHeight();
           sourceY++, targetY++)
      {
            sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
            targetPixel = this.getPixel(targetX,targetY);
            targetPixel.setColor(sourcePixel.getColor());
            }
      }
 }

 public void addBox()
 {
   Graphics g = this.getGraphics();
   g.setColor(Color.red);
   g.fillRect(150,200,50,50);
 }
 public void turnBrownIntoRed()
 {
//   Color brown = new Color(42, 25,15);
   Pixel[] pixels = this.getPixels();
   Pixel pixel = null;
   for (int i=0; i < pixels.length; i++)
   {
      pixel = pixels[i];
      if (pixel.colorDistance(Color.black) < 90.0)
         pixel.setColor(Color.pink);
   }
 }
} // end of class Picture, put all new methods before this
 