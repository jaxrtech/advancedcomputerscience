import java.awt.*;

public class SlowTurtle extends Turtle {
    ////////////////// constructors ///////////////////////

    /**
     * Constructor that takes the x and y and a picture to
     * draw on
     *
     * @param x       the starting x position
     * @param y       the starting y position
     * @param picture the picture to draw on
     */
    public SlowTurtle(ModelDisplay modelDisplay) {
        // let the parent constructor handle it
        super(modelDisplay);
        setColor(Color.magenta);
    }

    public void forward(int amount) {
        super.forward(amount);
        super.forward(amount);
    }


}