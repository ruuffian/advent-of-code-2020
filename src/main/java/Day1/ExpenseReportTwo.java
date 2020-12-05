package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ExpenseReportTwo {
    List<String> values = new ArrayList<String>();

    public Integer[] sumThree(String a) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(Objects.requireNonNull(getClass().getClassLoader().getResource(a)).getFile()));
        while (scanner.hasNext()) {
            values.add(scanner.next());
        }
        for (int i = 0; i < values.size(); i++) {
            for (int j = 1; j < values.size(); j++) {
                for (int k = 2; k < values.size(); k++) {
                    if (i != j) {
                        if (Integer.parseInt(values.get(i)) + Integer.parseInt(values.get(j)) + Integer.parseInt(values.get(k)) == 2020)
                            return new Integer[]{Integer.parseInt(values.get(i)), Integer.parseInt(values.get(j)), Integer.parseInt(values.get(k))};
                    }
                }
            }
        }
        return new Integer[]{0, 0, 0};
    }
}
