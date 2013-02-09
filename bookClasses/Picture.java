//Linda McDaniel
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.text.*;
import java.util.Random;

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
    
    public void pattern()
    {
        Random random = new Random();
        int originY = getHeight() - 385; // align to the fountains in the actual picture
        
        // Keep drawing random streams!
        for (int i = 0; i < 100; i++) {
            // Get random position
            int x = random.nextInt(getWidth()-1);
            
            // Get random speed in range
            double minSpeed = QuadraticDrawer.DEFAULT_SPEED - 0.25;
            double maxSpeed = QuadraticDrawer.DEFAULT_SPEED;
            double speed = minSpeed + (maxSpeed - minSpeed) * random.nextDouble();
            
            // Get random explosion time in range
            double minTime = QuadraticDrawer.DEFAULT_EXPLOSION_TIME - 2;
            double maxTime = QuadraticDrawer.DEFAULT_EXPLOSION_TIME;
            double time = minTime + (maxTime - minTime) * random.nextDouble();
            
            // Draw the stream
            QuadraticDrawer drawer = new QuadraticDrawer(this);
            drawer.setOrigin(new Point(x, originY));
            drawer.setDirection(Direction.getRandom());
            drawer.setColor(getRandomColor());
            drawer.drawStream(QuadraticDrawer.DEFAULT_GRAVITY, speed, time);
        }
    }
    
    public void grayscale()
    {
        apply(PixelFilters.getGrayscalePixelFilter());
    }
    
    public void maximizeGreen()
    {
        ColorChannelPixelFilter filter = PixelFilters.getMaxColorPixelFilter();
        filter.setColorChannel(ColorChannel.GREEN);
        apply(filter);
    }
    
    public void sepia()
    {
        // Get and set filters
        PixelFilter grayscale = PixelFilters.getGrayscalePixelFilter();
        PixelFilter sepia = PixelFilters.getSepiaTonePixelFilter();
        AdjustablePixelFilter brightness = PixelFilters.getBrightnessPixelFilter();
        brightness.setAdjustment(+20);
        
        // Combine them all in the correct order
        PixelFilter[] filters = new PixelFilter[] { grayscale, brightness, sepia };
        apply(filters);
    }
    
    public void brightness(int adjustment)
    {
        AdjustablePixelFilter filter = PixelFilters.getBrightnessPixelFilter();
        filter.setAdjustment(adjustment);
        apply(filter);
    }
    
    private void apply(PixelFilter filter)
    {
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                filter.filter(getPixel(x, y));
            }
        }
    }
    
    private void apply(PixelFilter[] filters)
    {
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                Pixel p = getPixel(x, y);
                for (PixelFilter f : filters)
                {
                    f.filter(getPixel(x, y));
                }
            }
        }
    }
    
    private Color getRandomColor()
    {
        Random r = new Random();
        return new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
    }
    
    public boolean inBounds(int x, int y)
    {
        if (x < getWidth() && x >= 0 &&
            y < getHeight() && y >= 0)
        {
            return true;
        }
        else return false;
    }
    
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
}
