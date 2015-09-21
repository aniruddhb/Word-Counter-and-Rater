import java.util.*;
import java.io.*;

public class CountWords {
    ArrayList <String> wordCounter = new ArrayList <String> ();
    ArrayList <wordObject> wordsWithCount = new ArrayList <wordObject> ();
    
    public void readFile(String fName){
        Scanner in = null;
        try {
            in = new Scanner(new File(fName));
        } catch (IOException io){
            io.printStackTrace();
        }
        
        while (in.hasNext()){
            String nextToken = in.next();
            if (nextToken.equals("-")){
            
            } else {
                nextToken = replaceAll(nextToken);
                wordCounter.add(nextToken.toLowerCase());
            }
        }
    }
    
    public String replaceAll(String token){
        String word = token.replaceAll("[\\p{Punct}&&[^'-]]", "");
        return word;
    }
    
    public void sortList(){
        Collections.sort(wordCounter);
    }
    
    public void sortWordList(){
        Collections.sort(wordsWithCount);
    }
    
    public void countFrequency(){
        for (int counterInArray = 0; counterInArray <= wordCounter.size() - 1; counterInArray++){
            int frequencyOfWord = 1;
            int newCounter = counterInArray;
            while (newCounter < wordCounter.size() - 1 && wordCounter.get(newCounter).equals(wordCounter.get(newCounter + 1))){
                frequencyOfWord++;
                newCounter++;
            }
            
            wordsWithCount.add(new wordObject(wordCounter.get(counterInArray), frequencyOfWord));
            counterInArray += (frequencyOfWord - 1);
        }
    }
    
    public void displayTop30(){
        for (int printArr = 1; printArr <= 30; printArr++){
            String itemToPrint = wordsWithCount.get(printArr - 1).getName();
            int freqOfWord = wordsWithCount.get(printArr - 1).getFreq();
            Formatter f = new Formatter();
            f.format("%4d%5d   %s", printArr, freqOfWord, itemToPrint);
            String formattedStats = f.toString();
            System.out.println(formattedStats);
        }
    }
    
    public static void main(String[] args){
        CountWords wC = new CountWords();
        wC.readFile("dream.txt");
        wC.sortList();
        wC.countFrequency();
        wC.sortWordList();        
        wC.displayTop30();
        System.out.println("\nNumber of Unique Words Used: " + wC.wordsWithCount.size());
        System.out.println("Total # of words: " + wC.wordCounter.size());
    }
}
