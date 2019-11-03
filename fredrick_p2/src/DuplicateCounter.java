import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.IOException;

public class DuplicateCounter {
    public Map<String,Integer> wordCounter = new HashMap<String, Integer>();

    public void remove(File dataFile){
        try{
            Scanner scanFile = new Scanner(dataFile);
            String word;
            boolean exists;
            while(scanFile.hasNext()){
                word = scanFile.next();
                if(wordCounter.containsKey(word)) {
                    Integer count = wordCounter.get(word);
                    count++;
                    wordCounter.put(word, count);
                }
                else {
                    wordCounter.put(word, 1);
                }
            }
            scanFile.close();
        }
        catch(FileNotFoundException e){
            System.err.println(e.getMessage());
        }

    }

    public void write(File outputFile){
        try{
            FileWriter writeFile = new FileWriter(outputFile);
            for(Map.Entry<String, Integer> it : wordCounter.entrySet()) {
                writeFile.write(it.getKey() + ": " + it.getValue() + " ");
            }
            writeFile.close();
        }
        catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
}