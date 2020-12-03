package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ExpenseReport {
    List<String> values = new ArrayList<>();

    public Integer[] sum2020(String a) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(Objects.requireNonNull(getClass().getClassLoader().getResource(a)).getFile()));
        while (scanner.hasNext()) {
            values.add(scanner.next());
        }
        for (int i = 0; i < values.size(); i++) {
            for (int j = 1; j < values.size(); j++) {
                if (i != j) {
                    if (Integer.parseInt(values.get(i)) + Integer.parseInt(values.get(j)) == 2020)
                        return new Integer[]{Integer.parseInt(values.get(i)), Integer.parseInt(values.get(j))};
                }
            }
        }
        return new Integer[]{0, 0};
    }
}
