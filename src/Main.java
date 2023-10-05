import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Dictionary obj = new Dictionary();
        obj.loadRecords();
        System.out.println(obj.findWord("hello"));
        try {
            obj.saveRecords();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        obj.showAllWords();
    }
}