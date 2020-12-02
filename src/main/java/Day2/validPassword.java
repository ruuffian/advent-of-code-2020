package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class validPassword {
    List<String> values = new ArrayList<>();

    public int isValidPassword(String a) throws FileNotFoundException {
        int valid = 0, low = 0, high = 0, occurences = 0;
        Scanner scanner = new Scanner(new File(Objects.requireNonNull(getClass().getClassLoader().getResource(a)).getFile()));
        while (scanner.hasNext()) {
            StringBuilder string = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                string.append(scanner.next()).append(" ");
            }
            values.add(string.toString());
        }
        for (String value : values) {
            String[] temp = value.split(" ");
            low = Integer.parseInt(temp[0].substring(0, temp[0].indexOf('-')));
            high = Integer.parseInt(temp[0].substring(temp[0].indexOf('-') + 1));
            char target = temp[1].charAt(0);
            occurences = 0;
            for (int j = 0; j < temp[2].length(); j++) {
                if (temp[2].charAt(j) == target) {
                    occurences++;
                }
            }
            if (low <= occurences && occurences <= high) {
                valid++;
            }
        }
        return valid;
    }
}