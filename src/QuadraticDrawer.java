import java.awt.Color;

public class QuadraticDrawer {
    public static final double DEFAULT_SPEED = 7.0;
    public static final double DEFAULT_GRAVITY = -(1 / 6.0);
    public static final double DEFAULT_EXPLOSION_TIME = 4.0;

    private final Picture picture;
    private Color color;
    private Direction direction;
    private Point origin;

    public QuadraticDrawer(Picture picture) {
        this.picture = picture;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color c) {
        this.color = c;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction d) {
        this.direction = d;
    }

    public Point getOrigin() {
        return this.origin;
    }

    public void setOrigin(Point o) {
        this.origin = o;
    }

    public void drawStream() {
        drawStream(DEFAULT_GRAVITY, DEFAULT_SPEED, DEFAULT_EXPLOSION_TIME);
    }

    public void drawStream(double gravity, double speed, double explosionTime) {
        double initial = 0;

        Point vertex = getProjectileMotionVertex(gravity, speed, initial);

        // Set the initial start and incrementation based on the direction
        double time = 0;
        double increment = 0.05;
        switch (direction) {
            case FORWARD:
                // Values are already set
                break;
            case BACKWARD:
                // Set time to the ending value
                double[] roots = getQuadraticRoots(gravity, speed, initial);
                for (double root : roots) {
                    if (root > 0) time = root;
                }
                break;
            default:
                // Values are already set
                break;
        }

        int actualX;
        int actualY;
        while (true) {
            double height = 5 * getProjectileMotionHeight(gravity, time, speed, initial);

            int x = (int) (time);
            int y = (int) (height);

            // Set the actual points
            // Note: the Y value is flipped in the image
            actualX = x + origin.getX();
            actualY = picture.getHeight() - (y + origin.getY()) - 1;

            // Stop if it gets to the explosion limit
            if (direction == Direction.FORWARD) {
                if (x > vertex.getX() + explosionTime) break;
            } else {
                if (x < vertex.getX() - explosionTime) break;
            }

            // Stop if it runs out of bounds
            if (!picture.inBounds(actualX, actualY))
                break;

            picture.getPixel(actualX, actualY).setColor(color);

            if (direction == Direction.FORWARD) {
                time += increment;
            } else {
                time -= increment;
            }
        }
    }

    private double getProjectileMotionHeight(double gravity, double time, double speed, double height) {
        /* Projectile motion formula: 
         * f(t) = gt^2 + st + h
         * f(t) = height
         * g = gravity (-16 is normal)
         * t = time
         * s = pixels per second
         * h = starting height
         */
        return (gravity * Math.pow(time, 2)) + (speed * time) + height;
    }

    private Point getProjectileMotionVertex(double gravity, double speed, double height) {
        /* Gets the x value of the vertex of the parabola
         * Quadratic function: y = ax2 + bx + c
         * Formula: x = -(b/2a)
         */
        double x = -speed / (2 * gravity);
        double y = getProjectileMotionHeight(gravity, x, speed, height);

        return new Point((int) x, (int) y);
    }

    private double[] getQuadraticRoots(double a, double b, double c) {
        // Quadratic formula
        double plus = (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
        double minus = (-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);

        return new double[]{plus, minus};
    }
}