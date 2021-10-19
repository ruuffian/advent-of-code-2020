package Day6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class SurveyTest {

    @Test
    void everyoneYes1() {
        Survey questions = null;
        try {
            questions = new Survey("Input6.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert questions != null;
        Assertions.assertEquals(6, questions.everyoneYes());
    }

    @Test
    void everyoneYes2() {
        Survey questions = null;
        try {
            questions = new Survey("Input3.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert questions != null;
        Assertions.assertEquals(3, questions.everyoneYes());
    }
}