package LineNumbererTest;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import LineNumberer.*;
import java.io.*;
import java.nio.file.*;

public class LineNumbererTest {

    private static final String OUTPUT_FILE = "output.txt";

    @BeforeEach
    public void setup() throws IOException {
        // 清理之前的测试输出文件
        Files.deleteIfExists(Paths.get(OUTPUT_FILE));
    }

    @AfterEach
    public void cleanup() throws IOException {
        // 测试完成后清理输出文件
        Files.deleteIfExists(Paths.get(OUTPUT_FILE));
    }

    @Test
    public void testAddLineNumbers() throws IOException {
        String inputFileName = "input.txt"; // 确保这个文件在类路径下可用
        LineNumberer.addLineNumbers(inputFileName, OUTPUT_FILE);

        // 验证输出文件是否存在
        assertTrue(Files.exists(Paths.get(OUTPUT_FILE)));

        // 验证输出文件内容是否包含行号
        try (BufferedReader reader = new BufferedReader(new FileReader(OUTPUT_FILE))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                assertTrue(line.startsWith(lineNumber + ":) "));
                lineNumber++;
            }
        }
    }
}
