import java.util.Scanner;
import java.io.File;

public class FileReader
{
    private Scanner sc;
    private String nextWord;
    
    //Create a file reader object that accesses the file specified by filename
    public FileReader(String filereader){
        try {
            sc = new Scanner(new File("LordOfTheRings.txt"));
        }
        catch (Exception e) {
            System.out.print("ERROR:  ");
            System.out.println(e);
            return;
        }
        setNext();  //get the first word in the file
    }
    
    //returns true if there are more words in the text file
    public boolean hasNextWord()
    {
        return nextWord != null;
    }
    
    //returns the next word in the text file
    public String getNextWord()
    {
        String ret = nextWord;
        setNext();
        return ret;
    }
    
    //used to set the nextWord that should be given back
    private void setNext(){
        if (!sc.hasNext()){  //nothing left
            nextWord = null;
            sc.close();
            return;
        }
        //make string lower case, and strip out most punctuation characters (leave ' and -)
        String str = sc.next().toLowerCase().replaceAll("[!“”\"\\#$%&()*+,./:;<=>?@\\[\\\\\\]^_‘{|}~]", "" );
        //if you're curious about that weird string in replaceAll,
        //you should look up Regular Expressions
        
        if (!str.equals(""))  //if str isn't empty its the next word
        {
            nextWord = str;
        }
        else {  //word was empty, so try to set it again
            setNext();
        }
    }
}
