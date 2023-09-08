
/**
 * This class represents a Fibonacci function
 * 
 * @author 
 * @version 
 */
public class Fibonacci
{
    // complete the following method
    public static int calculate(int n)
    {
        int lastLast = 1;
        int last = 1;
        if(n == 1){
            return lastLast;
        }
        if(n == 2){
            return last;
        }
        for(int i = 0; i < n - 2; i++){
            int temp = last;
            last = last + lastLast;
            lastLast = temp;
        }
        return last;
    }
}
