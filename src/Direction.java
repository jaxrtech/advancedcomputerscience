import java.util.Random;

public enum Direction
{
    FORWARD, BACKWARD;
    
    public static Direction getRandom()
    {
        Random random = new Random();
        Direction direction = (random.nextBoolean()) ? Direction.FORWARD : Direction.BACKWARD;
        
        return direction;
    }
}