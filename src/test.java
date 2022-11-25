
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class test {
    public static void main(String[] args) {
        HashMap<String, List<String>> javaBooksAuthorsMap = new HashMap<>();
        HashMap<String, List<String>> phpBooksAuthorsMap = new HashMap<>();
        List<HashMap> booksAuthorsMapsList = new ArrayList<>();
        javaBooksAuthorsMap.put("Head First Java", Arrays.asList("Kathy Sierra", "Bert Bates"));
        javaBooksAuthorsMap.put("Effective Java", Arrays.asList("Joshua Bloch"));
        javaBooksAuthorsMap.put("OCA Java SE 8",
                Arrays.asList("Kathy Sierra", "Bert Bates", "Elisabeth Robson"));
        phpBooksAuthorsMap.put("The Joy of PHP", Arrays.asList("Alan Forbes"));
        phpBooksAuthorsMap.put("Head First PHP & MySQL",
                Arrays.asList("Lynn Beighley", "Michael Morrison"));


        booksAuthorsMapsList.add(javaBooksAuthorsMap);
        booksAuthorsMapsList.add(phpBooksAuthorsMap);

        for (HashMap hashMap : booksAuthorsMapsList) {
            System.out.println(hashMap);
        }
    }
}
