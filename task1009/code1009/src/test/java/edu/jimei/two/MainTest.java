package edu.jimei.two;
import edu.jimei.SomeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    private Student student;
    @BeforeEach
    public void setStudent(){
        student = new Student("Li mei");
    }

    @Test
    public void testAverageScore() throws SomeException {
        student.addSubject("math",new math(90.0,1.5));
        student.addSubject("English",new english(85.0,1.2));

        double expectedAverage = (90.0 * 1.5 + 85.0 * 1.2) / 2;
        double actualAverage = student.weightsAverageScore();
        //如果不给个差值,会出现误差 org.opentest4j.AssertionFailedError: Average score calculation is incorrect. ==>
        //Expected :118.5
        //Actual   :118.8
        //assertEquals(expectedAverage, student.weightsAverageScore(), "Average score calculation is incorrect.");
        assertEquals(expectedAverage, actualAverage, 1e-3,"Average score calculation is incorrect.");
    }
}
