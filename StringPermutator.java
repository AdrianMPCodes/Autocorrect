import java.util.ArrayList;

class StringPermutator {

  public ArrayList<String> listPermutations;

  public ArrayList<String> allPermutations(String userWord) {
  // Pre: receives a word.
  // Post: returns all posssible permutations of that word in an arraylist.

    listPermutations = new ArrayList<String>();

    // Add every letter to every spot
    addLetters(userWord);
    // Delete a letter from each spot
    deleteLetters(userWord);
    // Swap two adjacent letters
    swapLetters(userWord);
    // Change each position to every letter
    changeLetters(userWord);

    return listPermutations;
  }

  public void addLetters(String word){
  // Pre: receives the user's word.
  // Post: returns nothing and adds the permutated words of the user's word to an array list by inserting a character before each letter.

  for (int i = 97; i <= 122; i++){
    // Converts ASCII value to a character
    char convertedLetter = (char)i;
    for (int j = 0; j <= word.length(); j++){
      StringBuffer newWord = new StringBuffer(word);

      // Inserts character into the string buffer
      newWord.insert(j, convertedLetter);
      
      //Adds the new string to the arraylist
      String newWordAsString = newWord.toString();
      listPermutations.add(newWordAsString);
      }
    }
  }
  
  public void deleteLetters(String word){
  // Pre: receives the user's word.
  // Post: returns nothing and adds the permutated words of the user's word to an array list by deleting each character.

  for (int i = 0; i < word.length(); i++){
    StringBuffer newWord = new StringBuffer(word);
    newWord.deleteCharAt(i);

    String newWordAsString = newWord.toString();
    listPermutations.add(newWordAsString);
    }
  }

  public void swapLetters(String word){
  // Pre: receives the user's word.
  // Post: returns nothing and adds the permutated words of the user's word to an array list by swapping the characters of the user's word.
  
  for (int i = 0; i < word.length()-1; i++){
    StringBuffer newWord = new StringBuffer(word);
    char firstLetter = newWord.charAt(i);
    char secondLetter = newWord.charAt(i+1);
    newWord.setCharAt(i, secondLetter);
    newWord.setCharAt(i+1, firstLetter);

    String newWordAsString = newWord.toString();
    listPermutations.add(newWordAsString);
    }
  }

  public void changeLetters(String word){
  // Pre: receives the user's word.
  // Post: returns nothing and adds the permutated words of the user's word to an array list by changing the characters of the user's word.

  for (int i = 97; i <= 122; i++){
    // Converts ASCII value to a character
    char convertedLetter = (char)i;
    for (int j = 0; j < word.length(); j++){
      StringBuffer newWord = new StringBuffer(word);

      // Replaces character in the string buffer
      newWord.setCharAt(j, convertedLetter);
      
      //Adds the new string to the arraylist
      String newWordAsString = newWord.toString();
      listPermutations.add(newWordAsString);
      }
    }
  }
}