package edu.jimei.one;


import java.util.Scanner;

import edu.jimei.SomeException;
import lombok.Getter;
import lombok.Setter;


import java.util.logging.Logger;


public class MainTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int set_model= scanner.nextInt();
        double radius_Perimeter_Area = scanner.nextDouble();
        try{
            Circle circle = new Circle(radius_Perimeter_Area,1);

            circle.Count(2);
            String result = String.valueOf(circle.Callback());
            System.out.println(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}

//异常类
