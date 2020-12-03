package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class TobogganSlope {
    public int trees(String a) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(Objects.requireNonNull(getClass().getClassLoader().getResource(a)).getFile()));
        String[] slope = new String[323];
        String[][] map = new String[323][31];
        int index = 0;
        while (scanner.hasNext()) { //loading rows
            slope[index] = scanner.next();
            index++;
        }
        for (int i = 0; i < slope.length; i++) { //map creation
            for (int j = 0; j < slope[i].length(); j++) {
                map[i][j] = "" + slope[i].charAt(j);
            }
        }

        int trees = 0, row = 0, col = 0; //setting start point
        while (row < slope.length) { //terminates when you reach the bottom
            if (("" + map[row][col].charAt(0)).equals("#"))
                trees++;
            row++;
            col += 3;
            if (col >= 31) //loops the horizontal direction infinitely
                col -= 31;
        }
        return trees;
    }
}