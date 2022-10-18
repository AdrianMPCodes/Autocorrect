import java.util.ArrayList;

class Autocorrect {
  private String word;
  private String suggestedBestMatch;
  private int frequency;
  private StringPermutator getAllPermutations;
  private CorrectWordsList getAllWordsBook;

  // Constructs autocorrect object
  public Autocorrect() {
    getAllPermutations = new StringPermutator();
    getAllWordsBook = new CorrectWordsList("GreatGatsby");
  }

  public String getBestMatch(String userWord){
  // Pre: receieves a word.
  // Pot: returns the word's best match, aka its autocorrected version.

    word = userWord;
    suggestedBestMatch = null;

    frequency = 0;

    // Checks to see if the word already exists and no autocorrecting needs to be done
    compareWord(word);

    if (suggestedBestMatch == null){
      frequency = 1;

      // Creates an arraylist to store all the permutations of a word
      ArrayList <String> allPermutationsList = getAllPermutations.allPermutations(word);

      // Checks one word at a time of the permutated list of words to compare it to the correct list of words to determine a best match
      for (int i = 0; i < allPermutationsList.size(); i++)
        compareWord(allPermutationsList.get(i));
    }
    return suggestedBestMatch;
  }

  private void compareWord(String permutatedWord){
  // Pre: receieves a word permutation or the original word for the first time.
  // Post: determines if the permutated word or the original word (first time) is the most frequent word in the list of correct words (all words from the Great Gatsby)

    int totalFrequencyWord = getAllWordsBook.wordFrequency(permutatedWord);
  
    if (totalFrequencyWord > frequency){
      frequency = totalFrequencyWord;
      suggestedBestMatch = permutatedWord.toLowerCase();
    }
  }
}