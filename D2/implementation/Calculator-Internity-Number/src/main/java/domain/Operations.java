package domain;

public class Operations {
    public static double add(double x, double y) {
        return x + y;
    }

    public static double subtract(double x, double y) {
        return x - y;
    }

    public static double multiple(double x, double y) {
        return x * y;
    }

    public static double division(double x, double y) {
        return x / y;
    }

    public static double calCircleArea(double r){
        return PI.getValue() * r * r ;
    }

    public static double calCircumference(double r){
        return PI.getValue() * r * 2 ;
    }
}
