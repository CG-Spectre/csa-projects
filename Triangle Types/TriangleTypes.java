
/**
 * This class classifies various triangle types
 *
 * @author 
 * @version 
 */
public class TriangleTypes
{
    // returns true if this is an Equilateral triangle, false if not
    public static boolean isEquilateral(int a, int b, int c)
    {
        return a ==b && b == c;    // replace this line
    }

    // returns true if this is an Isoceles triangle, false if not
    public static boolean isIsoceles(int a, int b, int c)
    {
        return a == b || a == c || b == c;    // replace this line
    }

    // returns true if this is a Scalene triangle, false if not
    public static boolean isScalene(int a, int b, int c)
    {
        return a != b && b != c && a != c;    // replace this line
    }

    // returns true if this is a Right triangle, false if not
    public static boolean isRight(int a, int b, int c)
    {
        double ad = (double)a;
        double cd = (double)c;
        double bd = (double)b;
        return (Math.pow(ad, 2) + Math.pow(bd, 2) == Math.pow(cd, 2)) || (Math.pow(ad, 2) + Math.pow(cd, 2) == Math.pow(bd, 2)) || (Math.pow(bd, 2) + Math.pow(cd, 2) == Math.pow(ad, 2));
    }

    // returns true if a triangle is possible with the given sides, false if not
    public static boolean isTriangle(int a, int b, int c)
    {
        return (c < a + b && c > Math.abs(a-b)) || (b < c + a && b > Math.abs(c-a)) || (a < c + b && a > Math.abs(c-b));    // replace this line
    }
}
