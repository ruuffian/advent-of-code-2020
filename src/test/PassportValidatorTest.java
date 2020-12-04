import Day4.PassportValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class PassportValidatorTest {

    @Test
    public void invalidStrictTest() throws FileNotFoundException {
        PassportValidator pass = new PassportValidator();
        Assertions.assertEquals(0, pass.totalValidStrict("Day4InvalidTest.txt"));
    }

    @Test
    public void validStrictTest() throws FileNotFoundException {
        PassportValidator pass = new PassportValidator();
        Assertions.assertEquals(4, pass.totalValidStrict("Day4ValidTest.txt"));
    }
}
