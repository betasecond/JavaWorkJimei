package TooBigException;

import java.util.Scanner;

public class SpecialIntegerInput {

    public void checkInteger(int number) throws TooBigExcept {
        if (number > 999) {
            throw new TooBigExcept("输入的数值太大: " + number);
        }
        System.out.println("输入的整数是: " + number);
    }

    public static void main(String[] args) {
        SpecialIntegerInput input = new SpecialIntegerInput();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数（不超过999）：");

        int number = scanner.nextInt();

        try {
            input.checkInteger(number);
        } catch (TooBigExcept e) {
            System.out.println("捕获到异常: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
