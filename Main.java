import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Autocorrect object
    Autocorrect correctWord = new Autocorrect();

    String word;

    do{
      // Gets word from user
      System.out.println("Enter a word or stop to quit: ");
      word = sc.next(); 

      String suggestedBestMatch = correctWord.getBestMatch(word);

      // Prints the result of the autocorrect
      if (suggestedBestMatch == null)
        System.out.println("The word you entered has no match.");
      else if (suggestedBestMatch.equalsIgnoreCase(word))
        System.out.println("The word you entered \"" + word + "\" is the best match.");
      else if (!word.equalsIgnoreCase("stop"))
        System.out.println("The autocorrected word is: " + suggestedBestMatch);
    } while (!word.equalsIgnoreCase("stop"));
  }
}

