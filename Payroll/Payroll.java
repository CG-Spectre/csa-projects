
/**
 * This Payroll class represents . . .
 *
 * @author  (your name)
 * @version (todays date)
 */
import java.util.Scanner;
public class Payroll
{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter hourly wage: ");
        double wage = scanner.nextDouble();
        System.out.println("Enter hours worked: ");
        double worked = scanner.nextDouble();
        double overtime = (worked - 40 > 0) ? worked%40 : 0;
        System.out.println("The total pay is $" + (Math.min(worked, 40)*wage+overtime*wage*1.5));
        
    }
}
