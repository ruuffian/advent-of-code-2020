package Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.Integer.MIN_VALUE;

public class BoardingPassCounter {
    List<BoardingPass> board = new ArrayList<>();

    public BoardingPassCounter(String a) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(Objects.requireNonNull(getClass().getClassLoader().getResource(a)).getFile()));
        while (scanner.hasNext()) {
            board.add(new BoardingPass(scanner.next()));
        }
    }

    public int maxSeatID() {
        int max = MIN_VALUE;
        for (BoardingPass boardingPass : board) {
            if (boardingPass.getSeatID() > max)
                max = boardingPass.getSeatID();
        }

        return max;
    }

    public int missingSeatID() {
        List<Integer> ids = new ArrayList<>();
        int missingSeat = -1;
        for (BoardingPass boardingPass : board) {
            ids.add(boardingPass.getSeatID());
        }

        Collections.sort(ids);
        for (int i = 0; i < ids.size() - 1; i++) {
            if ((ids.get(i + 1) != ids.get(i) + 1))
                missingSeat = ids.get(i) + 1;
        }

        return missingSeat;
    }
}
