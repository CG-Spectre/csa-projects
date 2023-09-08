
/**
 * This class calculates the surface area and volume 
 * of a cube of the provided side length.
 *
 * @author  (your name)
 * @version (today's date)
 */
public class Cube
{
    public static int surfaceArea(int length)
    {
        return (int)Math.pow(length, 2)*6;   // replace with your calculation
    }
    
    public static int volume(int length)
    {
        return (int)Math.pow(length, 3);   // replace with your calculation
    }
}