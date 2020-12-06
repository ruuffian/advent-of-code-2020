package Day6;

import Day4.PassportValidator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Survey {
    private List<String> info = new ArrayList<>(), forbidden = new ArrayList<>();

    public Survey(String a) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(Objects.requireNonNull(PassportValidator.class.getClassLoader().getResource(a)).getFile())).useDelimiter(Pattern.compile("^\\s*$", Pattern.MULTILINE));
        while (scanner.hasNext()) {
            String raw = scanner.next();
            StringBuilder input = new StringBuilder();
            for (int i = raw.length() - 1; i >= 0; i--) {
                if (!("" + raw.charAt(i)).equals("\n") && !("" + raw.charAt(i)).equals("\r") && !("" + raw.charAt(i)).equals(" ")) //so cool!
                    input.append(raw.charAt(i));
            }
            input.reverse();
            info.add(input.toString());
        }
    }

    public int uniqueQuestions() {
        int valid = 0;
        for (String s : info) {
            forbidden.clear();
            for (int j = 0; j < s.length(); j++) {
                if (!forbidden.contains("" + s.charAt(j))) {
                    valid++;
                    forbidden.add("" + s.charAt(j));
                }
            }
        }
        return valid;
    }
    public int allQuestions(){

        return 0;
    }
    public void specialFormat(String a) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(Objects.requireNonNull(PassportValidator.class.getClassLoader().getResource(a)).getFile())).useDelimiter(Pattern.compile("^\\s*$", Pattern.MULTILINE));
        while (scanner.hasNext()) {
            info.add(scanner.next());
        }
    }
}
