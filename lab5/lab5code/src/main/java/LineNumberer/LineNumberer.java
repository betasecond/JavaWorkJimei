package LineNumberer;

import java.io.*;
import java.util.Objects;

/**
 * @author nbdhc
 */
public class LineNumberer {
    public static void main(String[] args) throws FileNotFoundException {
        String inputFilePath = "input.txt";  // 资源文件名
        String outputFilePath = "output.txt"; // 输出文件名

        addLineNumbers(inputFilePath, outputFilePath);
    }

    public static void addLineNumbers(String inputFileName, String outputFileName) throws FileNotFoundException {
        ClassLoader classLoader = LineNumberer.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(inputFileName);
        OutputStream outputStream = new FileOutputStream(outputFileName); // 直接写入到输出文件

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {

            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                writer.write(lineNumber + ":) " + line);
                writer.newLine();
                lineNumber++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
