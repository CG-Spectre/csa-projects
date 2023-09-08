
/**
 * This ItemCounter class represents . . .
 *
 * @author  (your name)
 * @version (todays date)
 */
public class ItemCounter
{
    public static int itemCounter(String phrase, String item){
        int location = phrase.indexOf(item);
        if(location < 0){
            return 0;
        }
        int counter = 1;
        while(phrase.indexOf(item, location + 1) > 0){
            counter++;
            location = phrase.indexOf(item, location + 1);
        }
        return counter;
    }
}
