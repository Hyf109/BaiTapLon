import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {
    HashMap<String, Word> map = new HashMap<>();

    public void loadRecords() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\gtp11\\OneDrive\\Desktop\\Lthdt\\BTL\\src\\dictionaries.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                String[] parsedLine = line.split(",");
                String wordName = parsedLine[0];
                String meaning = parsedLine[1];
                Word word = new Word(wordName, meaning);
                this.map.put(wordName, word);

            }


            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String findWord(String word) {
        for (String i : map.keySet()) {
            if (i.equals(word)) {
                Word newWord = map.get(i);
                return newWord.word_explain;
            }
        }
        return null;
    }

    public void saveRecords() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\gtp11\\OneDrive\\Desktop\\Lthdt\\BTL\\src\\newDictionary.txt"));
        for (String i : map.keySet()) {
            Word newWord = map.get(i);
            bw.write(newWord.word_target);
            bw.write(",");
            bw.write(newWord.word_explain);
            bw.write("\n");

        }
        bw.close();
    }

    public String toString(Word thisWord, int index) {
        return String.format("%-5d| %-16s| %-30s",index, thisWord.word_target, thisWord.word_explain);
    }

    public void showAllWords() {
        System.out.println("No   | English         | Vietnamese");
        int j = 0;
        for(String i: map.keySet()) {
            System.out.println(toString(map.get(i), j++));
        }

    }


}
