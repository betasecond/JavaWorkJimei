package BigIntegerTest;

import TooBigException.SpecialIntegerInput;
import TooBigException.TooBigExcept;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class SpecialIntegerInputTest {

    @Test
    void testValidInput() {
        SpecialIntegerInput input = new SpecialIntegerInput();
        assertDoesNotThrow(() -> input.checkInteger(500)); // Should not throw any exception
    }

    @Test
    void testBoundaryInput() {
        SpecialIntegerInput input = new SpecialIntegerInput();
        assertDoesNotThrow(() -> input.checkInteger(999)); // Boundary check, should not throw
    }

    @Test
    void testTooBigInput() {
        SpecialIntegerInput input = new SpecialIntegerInput();
        TooBigExcept thrown;
        thrown = assertThrows(
                TooBigExcept.class,
                () -> input.checkInteger(1000) // No semicolon here
        );
        Assertions.assertTrue(thrown.getMessage().contains("数值太大"), "The message should indicate that the value is too big");
    }

}
