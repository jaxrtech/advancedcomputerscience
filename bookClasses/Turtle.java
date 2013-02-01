import java.util.Random;
import java.awt.Color;

/**
 * Class that represents a turtle which is similar to a Logo turtle.
 * This class inherts from SimpleTurtle and is for students
 * to add methods to.
 *
 * Copyright Georgia Institute of Technology 2004
 * @author Barb Ericson ericson@cc.gatech.edu
 * 
 */
public class Turtle extends SimpleTurtle
{   
    /** Constructor that takes the x and y and a picture to
      * draw on
      * @param x the starting x position
      * @param y the starting y position
      * @param picture the picture to draw on
      */
    public Turtle (int x, int y, Picture picture) 
    {
        // let the parent constructor handle it
        super(x,y,picture);
    }
    
    /** Constructor that takes the x and y and a model
      * display to draw it on
      * @param x the starting x position
      * @param y the starting y position
      * @param modelDisplayer the thing that displays the model
      */
    public Turtle (int x, int y, ModelDisplay modelDisplayer) 
    {
        // let the parent constructor handle it
        super(x,y,modelDisplayer);
    }
    
    /** Constructor that takes the model display
      * @param modelDisplay the thing that displays the model
      */
    public Turtle (ModelDisplay modelDisplay) 
    {
        // let the parent constructor handle it
        super(modelDisplay);
    }
    
    /**
     * Constructor that takes a picture to draw on
     * @param p the picture to draw on
     */
    public Turtle (Picture p)
    {
        // let the parent constructor handle it
        super(p);
    }
   
    
    
    // Well this draws more of a house
    public void drawShape()
    {
        // Points
        Point p1 = new Point(260,160);
        Point p2 = new Point(420,160);
        Point p3 = new Point(180,200);
        Point p4 = new Point(340,200);
        Point p5 = new Point(260,300);
        Point p6 = new Point(420,300);
        Point p7 = new Point(180,340);
        Point p8 = new Point(340,340);
        Point t1 = new Point(260,120);
        Point t2 = new Point(340,60);
        // Draw the house as a cube
        this.drawCube(p1, p2, p3, p4, p5, p6, p7, p8);
        // Draw the roof
        this.drawPrism(t1, t2, p1, p2, p3, p4);
        // Draw the door
        this.drawRectangle(new Point(240,280), new Point(280,340));
        // Draw the windows
        this.drawRectangle(new Point(200,220), new Point(240,260));
        this.drawLine(new Point(220,220), new Point(220,260));
        this.drawLine(new Point(200,240), new Point(240,240));
        this.drawRectangle(new Point(280,220), new Point(320,260));
        this.drawLine(new Point(300,220), new Point(300,260));
        this.drawLine(new Point(280,240), new Point(320,240));
    }
    
    public void drawSquare(int size)
    {
        this.drawRectangle(size, size);
    }
    
    public void draw2Triangles(int size1, int size2)
    {
        this.drawTriangle(size1);
        this.turn(120);
        this.drawTriangle(size2);
    }
    
    public void drawTriangle(int size)
    {
        for (int i = 0; i < 3; i++) {
            this.turn(120);
            this.forward(size);
        }
    }
    
    public void drawRectangle(int width, int height)
    {
        // Draw starting from the bottom left-hand corner
        this.forward(height);
        this.turn(90);
        this.forward(width);
        this.turn(90);
        this.forward(height);
        this.turn(90);
        this.forward(width);
        this.turn(90);
    }
    
    public void drawRectangle(Point topLeft, Point bottomRight)
    {
        this.penUpAndDownTo(topLeft);
        this.moveTo(topLeft.getX(), bottomRight.getY());
        this.moveTo(bottomRight);
        this.moveTo(bottomRight.getX(), topLeft.getY());
        this.moveTo(topLeft);
    }
    
    public void drawTriangle(Point p1, Point p2, Point p3) 
    {
        this.penUpAndDownTo(p1);
        this.moveTo(p1);
        this.moveTo(p2);
        this.moveTo(p3);
    }
    
    public void drawQuad(Point topLeft, Point topRight, Point bottomLeft, Point bottomRight)
    {
        this.penUpAndDownTo(topLeft);
        this.moveTo(topRight);
        this.moveTo(bottomRight);
        this.moveTo(bottomLeft);
        this.moveTo(topLeft);
    }
    
    public void drawCube(Point p1, Point p2, Point p3, Point p4, Point p5, Point p6, Point p7, Point p8)
    {
        // Front
        this.drawRectangle(p3, p8);
        // Back
        this.drawRectangle(p1, p6);
        // Left
        this.drawQuad(p3, p1, p7, p5);
        // Right
        this.drawQuad(p4, p2, p8, p6);
        // Top
        this.drawQuad(p1, p2, p3, p4);
        // Bottom
        this.drawQuad(p5, p6, p7, p8);
    }
    
    public void drawPrism(Point t1, Point t2, Point p1, Point p2, Point p3, Point p4)
    {
        // Front
        this.drawTriangle(t1, p3, p4);
        // Back
        this.drawTriangle(t2, p1, p2);
        // Left
        this.drawQuad(t1, t2, p3, p1);
        // Right
        this.drawQuad(t1, t2, p4, p2);
        // Bottom
        this.drawQuad(p1, p2, p3, p4);
    }
    
    public void drawSquareSpiral(int size, int turn)
    {
        for (int i = 1; i <= 150; i++) {
            this.drawSquare(size);
            this.turn(turn);
        }
    }
    
    public void drawCircleSpiral(int size, int turn)
    {
        for (int i = 1; i <= 150; i++) {
            this.drawCircle(size);
            this.turn(turn);
        }
    }
    
    public void drawPoints(Point[] points)
    {
        for (Point p : points) {
            this.moveTo(p);
        }
    }
    
    public void drawLine(Point p1, Point p2)
    {
        this.penUpAndDownTo(p1);
        this.moveTo(p2);
    }    
    
    public void drawCircle(int size)
    {
        for (int i = 0; i < 72; i++) {
            this.forward(size);
            this.turn(5);
        }
    }
    
    public void moveTo(Point p)
    {
        this.moveTo(p.getX(), p.getY());
    }
    
    public void penUpAndDownTo(int x, int y)
    {
        this.penUp();
        this.moveTo(x, y);
        this.penDown();
    }
    
    public void penUpAndDownTo(Point p)
    {
        this.penUpAndDownTo(p.getX(), p.getY());
    }
    
    public void turnNorth()
    {
        this.setHeading(0.0);
    }
    
    public static Color getRandomColor()
    {
        Random r = new Random();
        return new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
    }
    
    public boolean equals(Turtle t)
    {
        return ((this.getXPos() == t.getXPos()) && (this.getYPos() == t.getYPos()));
    }
}

