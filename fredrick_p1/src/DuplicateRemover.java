import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.io.IOException;
import java.util.Set;

public class DuplicateRemover {
    public Set<String> uniqueWords = new HashSet<String>();

    public void remove(File dataFile){

        try{
            Scanner scanFile = new Scanner(dataFile);
            String word;

            while(scanFile.hasNext()){
                word = scanFile.next();
                if(!(uniqueWords.contains(word)))
                    uniqueWords.add(word);
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
            writeFile.write(String.valueOf(uniqueWords));
            /*for(int j = 0; j < uniqueWords.size(); j++) {
                writeFile.write(uniqueWords.get(j));
                writeFile.write(" ");
            }*/
            writeFile.close();
        }
        catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
}