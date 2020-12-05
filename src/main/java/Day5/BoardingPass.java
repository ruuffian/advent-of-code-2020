package Day5;

public class BoardingPass {
    private int row, col, seatID;

    public BoardingPass(String a) {
        int row1 = 0, row2 = 127;
        for (int i = 0; i < 8; i++) {
            if (("" + a.charAt(i)).equals("B")) {
                row1 = (row1 + row2) / 2 + 1;
            } else {
                row2 = (row1 + row2) / 2;
            }
        }
        row = row2;
        int col1 = 0, col2 = 7;
        for (int i = 7; i < 10; i++) {
            if (("" + a.charAt(i)).equals("R")) {
                col1 = (col1 + col2) / 2 + 1;
            } else {
                col2 = (col1 + col2) / 2;
            }
        }
        col = col2;
        seatID = 8 * row + col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getSeatID() {
        return seatID;
    }

}
