import java.util.*;

public class wordObject implements Comparable <wordObject> {
    String wordName = "";
    int frequency = 0;
    
    public wordObject(String wordName, int frequency){
        this.wordName = wordName;
        this.frequency = frequency;
    }
    
    public int getFreq(){
        return frequency;
    }
    
    public String getName(){
        return wordName;
    }
    
    public int compareTo(wordObject secondWord){
        return secondWord.getFreq() - this.getFreq();
    }
    
    public boolean equals(wordObject secondWord){
        return this.getName().equalsIgnoreCase(secondWord.getName());
    }
    
    public String toString(){
        return "(" + this.getName() + ", " + this.getFreq() + ")";
    }
}
