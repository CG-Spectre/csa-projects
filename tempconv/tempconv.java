
/**
 * Write a description of class main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class tempconv
{
    public static void main(String[] args){
        // instance variables - replace the example below with your own
        Scanner scanner = new Scanner(System.in);
        double f;
        double c;
        
        System.out.print("Enter degrees Fahrenheit: ");
        f = scanner.nextDouble();
        
        c = (f - 32) * 5/9;
        
        System.out.println("Celsius equivalent: " + c);
    }
}
