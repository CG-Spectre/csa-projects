
/**
 * This class represent some basic String object utilities
 *
 * @author  (your name)
 * @version (today's date)
 */
public class StringUtilities
{
    /** Returns the first character in string
     *  Precondition: string.length() >= 1 
     */
    public static String getFirstCharacter(String string) 
    { 
        return string.charAt(0)+"";    // replace this line
    } 

    /** Returns the last character in string
     *  Precondition: string.length() >= 1 
     */
    public static String getLastCharacter(String string) 
    { 
        return string.charAt(string.length()-1)+"";    // replace this line
    } 

    /** Returns a random character from string 
     *  Precondition:  string.length() >= 1
     */
    public static String getRandomCharacter(String string)
    { 
        return string.charAt((int)Math.round((string.length() - 1)*Math.random())) + "";    // replace this line
    }
} 
