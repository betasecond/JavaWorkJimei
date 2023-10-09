package edu.jimei;
import java.util.Scanner;
import lombok.Getter;
import lombok.Setter;
import java.util.logging.Logger;


public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int set_model= scanner.nextInt();
        double radius_Perimeter_Area = scanner.nextDouble();
        try{
            Circle circle = new Circle(radius_Perimeter_Area,set_model);
            String result = String.valueOf(circle.Callback());
            System.out.println(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
@Getter @Setter
class Circle{
    private static final Logger LOGGER = Logger.getLogger(Circle.class.getName());

    private final double pi = Math.PI;
    private double radius;
    private double perimeter;
    private double area;

    Circle(){};
    Circle(double value,int setModel){
        switch (setModel){
            case 0 ->{
                setRadius(value);
            }
            case 1 ->{
                setPerimeter(value);
            }
            case 2 ->{
                setArea(value);
            }
            default -> {

            }
        }
        try{
            Count(setModel);
        }catch (SomeException e){
            LOGGER.severe("Error calculating circle properties: " + e.getMessage());
        }finally {

        }


    };
    void Count(int set_model) throws SomeException{
        switch (set_model){

            case 0 -> {
                if(this.radius==0){
                    throw new SomeException("Radius cannot be zero.");
                }
                this.perimeter = this.radius*this.pi*2;
                this.area = Math.pow(this.radius,2)*this.pi;
            }
            case 1 -> {
                if(this.perimeter ==0){


                    LOGGER.info("This is an info message");
                    throw new SomeException("Perimeter cannot be zero.");

                }
                this.radius = this.perimeter /(2.0*this.pi);
                this.area = Math.pow(this.radius,2)*this.pi;
            }
            case 2 -> {
                if(this.area ==0){


                    LOGGER.info("This is an info message");
                    throw new SomeException("Area cannot be zero.");

                }
                this.radius = Math.pow(this.area /pi,0.5);
                this.perimeter = this.radius*this.pi*2;
            }
            default -> {
                LOGGER.info("This is an info message");
                throw new SomeException("Invalid set model.");

            }
        }

    }
    StringBuilder Callback() throws SomeException{
        StringBuilder status = new StringBuilder();

        status.append("Circle properties:\n");
        if(this.radius==0){
            throw new SomeException("radius have no value");
        }
        if(this.perimeter ==0){
            throw new SomeException("perimeter hava no value");
        }
        if(this.area ==0){
            throw new SomeException("Area have no value");
        }
        status.append("Circle properties: Radius:").append(this.getRadius());
        status.append("\nCircle properties: Perimeter:").append(this.getPerimeter());
        status.append("\nCircle properties: Area:").append(this.getArea());
        return status;
    }

}
//异常类
