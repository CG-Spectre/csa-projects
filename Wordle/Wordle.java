import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * This class represents an implementation of the popular Wordle game, where the user
 * attempts to guess a random five letter word within six tries
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Wordle
{
    /** main method creates a new Wordle object */
    public static void main(String[] args)
    {
        new Wordle().run();
    }

    /** Initiates a new Wordle game */
    public void run()
    {
        wordle.addEnterListener((guess) -> enterAction(guess));
    }

    /** Wordle instance variables */
    private WordleGUI wordle;
    private ArrayList<String> validWords;
    private String secretWord;

    /** Wordle constuctor */
    public Wordle()
    {
        wordle = new WordleGUI();
        loadValidWords();
        secretWord = pickSecretWord();        
    }

    /** Method called whenever the Return key is pressed
     *  or Enter button is tapped */
    private void enterAction(String guess)
    {
        if(validWords.contains(guess))
        {
            if(checkLetters(guess))
                wordle.showMessage("Success!");
            else if (wordle.getCurrentRow() < wordle.N_ROWS - 1)
                wordle.setCurrentRow(wordle.getCurrentRow() + 1);
            else
                wordle.showMessage(secretWord);
        }
        else
            wordle.showMessage("Not in word list");

    }

    /** Checks each letter of guess to secretWord 
     *  and colors each letter displayed appropriately.
     *  Returns true if guess is secretWord, false otherwise. */
    private boolean checkLetters(String guess)
    {
        setAllLettersToMissing();
        if(findCorrectLetters(guess))
            return true;
        findPresentLetters(guess);
        return false;
    }

    /** Set all letters to missing (gray) color */
    private void setAllLettersToMissing()
    {
        throw new RuntimeException("Insert Step 0 code here");    // replace this line
    }

    /** Set correctly placed letters to correct (green) color */
    private boolean findCorrectLetters(String guess)
    {
        throw new RuntimeException("Insert Step 1 code here");    // replace this line
    }

    /** count the number of present letters */
    private int presentLetterCount(String letter)
    {
        throw new RuntimeException("Insert Step 2 code here");    // replace this line
    }
    
    /** Set the appropriate number of present letters to present (yellow) color */
    private void findPresentLetters(String guess)
    {
        throw new RuntimeException("Insert Step 3 code here");    // replace this line
    }

    /** Gets valid words */
    private void loadValidWords()
    {
        validWords = getWords("Valid Words.txt");
    }

    /** Gets possible Wordle Words and randomly selects one of them to be the secret word */
    private String pickSecretWord()
    {
        ArrayList<String> words = getWords("Wordle Words.txt");

        int random = (int)(Math.random() * words.size());
        return words.get(random);
    }

    /** Reads in words from a file */
    private ArrayList<String> getWords(String fileName)
    {
        ArrayList<String> words = new ArrayList<String>();
        try
        {
            Scanner reader = new Scanner(new File(fileName));
            while(reader.hasNext())
            {
                String word = reader.nextLine();
                words.add(word);
            }
            reader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println(fileName + " file not found");
        }
        return words;
    }
}
