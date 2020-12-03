package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MultipleSlopes {
    public Long multipleTrees(String a) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(Objects.requireNonNull(getClass().getClassLoader().getResource(a)).getFile()));
        String[] slope = new String[323];
        String[][] map = new String[323][31];
        int index = 0;
        while (scanner.hasNext()) { //loading rows
            slope[index] = scanner.next();
            index++;
        }
        for (int i = 0; i < slope.length; i++) { //generates map
            for (int j = 0; j < slope[i].length(); j++) {
                map[i][j] = "" + slope[i].charAt(j);
            }
        }

        long result = 1; //initialized as 1 because *= doesnt like 0
        List<Long> results = new ArrayList<>();
        int[] slopes = new int[]{11, 31, 51, 71, 12}; //initializes array of traversal instructions, 31 = 3 right 1 down
        for (int value : slopes) {
            long trees = 0;
            int right = value / 10, down = value % 10; //typecasting was fixed!!!
            int row = 0, col = 0;
            while (row < slope.length) {
                if (("" + map[row][col].charAt(0)).equals("#"))
                    trees++;
                row += down;
                col += right;
                if (col >= 31)
                    col -= 31;
            }
            results.add(trees);
        }

        for (Long number : results) {
            result *= number;
        }

        return result;
    }
}
