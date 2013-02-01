import java.awt.*;
import java.util.*;

/**
 * Class that represents a turtle which is similar to a Logo turtle.
 * This class inherts from SimpleTurtle and is for students
 * to add methods to.
 *
 * Copyright Georgia Institute of Technology 2004
 * @author Barb Ericson ericson@cc.gatech.edu
 * 
 */
public class DoubleTurtle extends Turtle
{
  ////////////////// constructors ///////////////////////
  
    public DoubleTurtle (ModelDisplay m) 
  {
    super(m);
    setColor(Color.yellow);
  }
  
   ////////methods//////////////
  
  public void forward(int amount)
  {
       super.forward(amount*2);
  }
    
  
}