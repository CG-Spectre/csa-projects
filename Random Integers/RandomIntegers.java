
/**
 * This class represents a variety of methods that generate random integer values
 * 
 * @author 
 * @version 
 */
import java.util.Random;
import java.util.Arrays;
public class RandomIntegers
{
    /* Returns a random integer from 0 to n - 1
     * @param n the upper limit (exclusive)
     * Precondition: n > 0
     * @return a random integer from 0 to n - 1
     */
    public static int randomInteger(int n)
    {
        if(n > 0){
            int num = (int)(n*Math.random());
            return num;
        }
         return -1;
    }
    
    /* Returns a random integer from 'start' to 'end' (inclusive)
     * @param start the lower limit of random numbers (inclusive)
     * @param end the upper limit of random numbers (inclusive)
     * Precondition: 0 <= start <= end
     * @return a random integer from 'start' to 'end' (inclusive)
     */
    public static int randomInteger(int start, int end)
    {
        Random random = new Random();
        int range = end - start + 1;
        int randomNumber = random.nextInt(range) + start;
        return randomNumber;
    }
    
    /* Returns one of 'count' integers spaced 'span' units apart beginning at 'start'.
     * For example, the call randomInteger(5, 20, 10) should randomly generate
     * one of the following integers [10, 30, 50, 70, 90]. In this example
     * there are a total of five possibilities (count), 
     * spaced 20 numbers apart (span),
     * beginning at 10 (start).
     * @param count the amount of possible random numbers
     * @param span how far apart are each possible random number
     * @param start the lower limit of random numbers (inclusive)
     * Precondition: count > 0, span > 0, and start >= 0
     * @return one of 'count' integers spaced 'span' units apart beginning at 'start'
     */
    public static int randomInteger(int count, int span, int start)
    {
        int[] randNums = {};
        for(int i = start; i < (start + count*span); i+=span){
            randNums = Arrays.copyOf(randNums, randNums.length + 1);
            randNums[randNums.length - 1] = i;
        }
        return (randNums[(int)(float)(Math.random()*(randNums.length))]);
    }
}
