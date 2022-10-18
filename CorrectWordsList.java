import java.util.Scanner;
import java.util.ArrayList;

class CorrectWordsList {
  private ArrayList <String> allWordsInBook; 
  private ArrayList <Integer> allWordsFrequency; 

  public CorrectWordsList(String txt){
    allWordsInBook = new ArrayList <String>();
    allWordsFrequency = new ArrayList <Integer>();

    FileReader reader = new FileReader(txt);

    while (reader.hasNextWord()){
      String word = reader.getNextWord().toLowerCase();
      // Finds the position of the word in the wordMatches to see if the arraylist already contains the word
      int position = allWordsInBook.indexOf(word);
      // If the word doesn't exist in the arraylist, it is added to it
      if (position == -1){
        allWordsInBook.add(word);
        allWordsFrequency.add(1);
      }
      // If the word already exists, one is added to its frequency
      else
        allWordsFrequency.set(position, allWordsFrequency.get(position)+1);
    }
  }

  public int wordFrequency(String word){
    // Pre: receives a word.
    // Post: returns the word's frequency in the text.

    // Finds the position of the word in the array of all words to get its position in the array that stores frequency
    int position = allWordsInBook.indexOf(word.toLowerCase());

    // If the position of the word equals -1, then it doesn't exist so its frequency is 0
    if (position == -1)
      return 0;
    // If the word does exist, the method returns its frequency by returning the element (the integer in this case) at the position found earlier
    return allWordsFrequency.get(position);
  }
}