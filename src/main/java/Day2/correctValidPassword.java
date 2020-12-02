package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class correctValidPassword {
    List<String> values = new ArrayList<>();

    public int numberValid(String a) throws FileNotFoundException {
        int valid = 0, pos1 = 0, pos2 = 0;
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
            pos1 = Integer.parseInt(temp[0].substring(0, temp[0].indexOf('-'))) - 1;
            pos2 = Integer.parseInt(temp[0].substring(temp[0].indexOf('-') + 1)) - 1;
            char target = temp[1].charAt(0);
            if ((temp[2].charAt(pos1) == target && temp[2].charAt(pos2) != target) || (temp[2].charAt(pos2) == target && temp[2].charAt(pos1) != target)) {
                valid++;
            }
        }
        return valid;
    }
}
