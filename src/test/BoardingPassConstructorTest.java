import Day5.BoardingPass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardingPassConstructorTest {
    @Test
    public void constructorTest1() {
        BoardingPass pass = new BoardingPass("FBFBBFFRLR");
        Assertions.assertEquals(44, pass.getRow());
    }

    @Test
    public void constructorTest2() {
        BoardingPass pass = new BoardingPass("FBFBBFFRLR");
        Assertions.assertEquals(5, pass.getCol());
    }

    @Test
    public void constructorTest3() {
        BoardingPass pass = new BoardingPass("FBFBBFFRLR");
        Assertions.assertEquals(357, pass.getSeatID());
    }

    @Test
    public void constructorTest4() {
        BoardingPass pass = new BoardingPass("BFFFBBFRRR");
        Assertions.assertEquals(70, pass.getRow());
    }

    @Test
    public void constructorTest5() {
        BoardingPass pass = new BoardingPass("BFFFBBFRRR");
        Assertions.assertEquals(7, pass.getCol());
    }

    @Test
    public void constructorTest6() {
        BoardingPass pass = new BoardingPass("BFFFBBFRRR");
        Assertions.assertEquals(567, pass.getSeatID());
    }

    @Test
    public void constructorTest7() {
        BoardingPass pass = new BoardingPass("FFFBBBFRRR");
        Assertions.assertEquals(14, pass.getRow());
    }

    @Test
    public void constructorTest8() {
        BoardingPass pass = new BoardingPass("FFFBBBFRRR");
        Assertions.assertEquals(7, pass.getCol());
    }

    @Test
    public void constructorTest9() {
        BoardingPass pass = new BoardingPass("FFFBBBFRRR");
        Assertions.assertEquals(119, pass.getSeatID());
    }

    @Test
    public void constructorTest10() {
        BoardingPass pass = new BoardingPass("BBFFBBFRLL");
        Assertions.assertEquals(102, pass.getRow());
    }

    @Test
    public void constructorTest11() {
        BoardingPass pass = new BoardingPass("BBFFBBFRLL");
        Assertions.assertEquals(4, pass.getCol());
    }

    @Test
    public void constructorTest12() {
        BoardingPass pass = new BoardingPass("BBFFBBFRLL");
        Assertions.assertEquals(820, pass.getSeatID());
    }
}
