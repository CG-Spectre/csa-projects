import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.awt.Color;

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
        int row = wordle.getCurrentRow();
        for(int i = 0; i < wordle.N_COLS; i++){
            String letter = wordle.getSquareLetter(row, i);
            wordle.setSquareColor(row, i, wordle.MISSING_COLOR);
            wordle.setKeyColor(letter, wordle.MISSING_COLOR);
        }
    }

    /** Set correctly placed letters to correct (green) color */
    private boolean findCorrectLetters(String guess)
    {
        int row = wordle.getCurrentRow();
        for(int i = 0; i < wordle.N_COLS; i++){
            String guessLetter = guess.substring(i, i+1);
            String answerLetter = secretWord.substring(i, i+1);
            if(guessLetter.equals(answerLetter)){
                String letter = wordle.getSquareLetter(row, i);
                wordle.setSquareColor(row, i, wordle.CORRECT_COLOR);
                wordle.setKeyColor(letter, wordle.CORRECT_COLOR);
            }
        }
        return guess.equals(secretWord);
    }

    /** count the number of present letters */
    private int presentLetterCount(String letter)
    {
        String temp = secretWord;
        int count = 0;
        int row = wordle.getCurrentRow();
        while(temp.indexOf(letter) >= 0){
            temp = temp.substring(temp.indexOf(letter) + 1);
            count++;
        }
        int countCorrect = 0;
        for(int i = 0; i < wordle.N_COLS; i++){
            Color color = wordle.getSquareColor(row, i);
            if(color == wordle.CORRECT_COLOR && wordle.getSquareLetter(row, i).equals(letter)){
                countCorrect++;
            }
        }
        return count - countCorrect;
    }
    
    /** Set the appropriate number of present letters to present (yellow) color */
    private void findPresentLetters(String guess)
    {
        int row = wordle.getCurrentRow();
        for(int i = 0; i < guess.length(); i++){
            String letter = guess.substring(i, i+1);
            int present = presentLetterCount(letter);
            int changed = 0;
            for(int t = 0; t < guess.length(); t++){
                if(changed < present){
                    if(letter.equals(guess.substring(t, t+1)) && !letter.equals(secretWord.substring(t, t+1))){
                        String letterC = wordle.getSquareLetter(row, t);
                        wordle.setSquareColor(row, t, wordle.PRESENT_COLOR);
                        if(wordle.getKeyColor(letterC) != wordle.CORRECT_COLOR){
                            wordle.setKeyColor(letterC, wordle.PRESENT_COLOR);
                        }
                        changed++;
                    }
                }else{
                    break;
                }
            }
        }
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
