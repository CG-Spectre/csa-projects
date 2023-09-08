
/**
 * This class calculates the circumference, surface area, and volume 
 * of a sphere of the provided radius.
 *
 * @author  (your name here)
 * @version (today's date)
 */
public class Sphere
{
    public static double circumference(int radius)
    {
        return radius*Math.PI*2;     // replace this line
    }
    
    public static double surfaceArea(int radius)
    {
        return 4*Math.PI*Math.pow(radius, 2);     // replace this line
    }
    
    public static double volume(int radius)
    {
        return (4.0/3.0) * Math.PI* Math.pow(radius, 3);     // replace this line
    }
}