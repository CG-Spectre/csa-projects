
/**
 * This class simulates the rolling of dice represented 
 * by a String using dice notation (e.g. 3d20 -> 3 dice, each with 20 sides)
 *
 * @author  
 * @version 
 */
public class DiceNotation
{    
    /** 
     * Simulates the rolling of a single die with faces number of sides
     * Returns a random integer between 1 and faces, inclusive.
     */
    public static int rollDie(int faces)
    {
        return (int)(Math.random() * (faces) + 1);
    }

    /**
     * Simulates the rolling of muliple dice, using dice notation
     * Precondition: diceNotation is a valid dice notation in the format of NdF, where
     *                  N is the number of dice (an integer)
     *                  d is the delimiting (separation) character between the two values
     *                  F is the number of faces on each die (an integer)
     */
    public static int rollDice(String diceNotation)
    {
        int n = Integer.parseInt(diceNotation.split("d")[0]);
        int f = Integer.parseInt(diceNotation.split("d")[1]);
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += rollDie(f);
        }
        return sum;
    }
    
    /** 
     * This helper method is provided to easily convert a String to an int
     * Precondion: String string must contain only integer values
     */
    private static int parseInt(String string)
    {
        return Integer.parseInt(string);
    }
}
