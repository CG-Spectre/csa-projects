
/**
 * This class performs some basic word processing functions, 
 * namely find, remove, and replace.
 *
 * @author  (your name)
 * @version (today's date)
 */
public class WordProcessor
{
    public static boolean find(String phrase, String item){
        return phrase.indexOf(item) != -1;
    }
    public static String remove(String phrase, String item){
        if(!find(phrase, item)){
            return phrase;
        }
        int index = phrase.indexOf(item);
        String b = phrase.substring(0, index);
        String e = phrase.substring(index + item.length(), phrase.length());
        return b+e;
    }
    public static String replace(String phrase, String item, String replacement){
        return phrase.replace(item, replacement);
    }
}
