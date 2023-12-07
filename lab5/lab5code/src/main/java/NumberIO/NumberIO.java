package NumberIO;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class NumberIO {

    private static final String TEST_FILE = "num.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] numbers = new Integer[8];

        // 获取用户输入
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("请输入第 " + (i + 1) + " 个整数:");
            numbers[i] = scanner.nextInt();
        }

        // 写入文件
        writeNumbersToFile(numbers);

        // 使用字节流读取并排序
        System.out.println("使用字节流排序结果:");
        Integer[] byteStreamResult = readAndSortUsingByteStream(TEST_FILE);
        System.out.println(Arrays.toString(byteStreamResult));

        // 使用字符流读取并排序
        System.out.println("使用字符流排序结果:");
        Integer[] charStreamResult = readAndSortUsingCharStream(TEST_FILE);
        System.out.println(Arrays.toString(charStreamResult));
    }

    static void writeNumbersToFile(Integer[] numbers) {
        try (FileWriter fileWriter = new FileWriter("num.txt")) {
            for (Integer number : numbers) {
                fileWriter.write(number + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Integer[] readAndSortUsingByteStream(String testFile) {
        try (FileInputStream fileInputStream = new FileInputStream("num.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream))) {
            return sortNumbers(reader);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    static Integer[] readAndSortUsingCharStream(String testFile) {
        try (FileReader fileReader = new FileReader(testFile);
             BufferedReader reader = new BufferedReader(fileReader)) {
            return sortNumbers(reader);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Integer[] sortNumbers(BufferedReader reader) throws IOException {
        Integer[] numbers = new Integer[8];
        String line;
        int i = 0;

        while ((line = reader.readLine()) != null) {
            numbers[i++] = Integer.parseInt(line);
        }
        Arrays.sort(numbers, Collections.reverseOrder());
        return numbers;
    }
}
