package domain;

import java.text.DecimalFormat;

public class PI {

    private static int PRECISE_DEGREE_INFINITE_SERIES = 5000000;
    private static int PRECISE_DEGREE_CUT_CIRCLE = 12;
    public static int algrithem = 1;
    public static String degree = "MEDIUM";

    static DecimalFormat fmt = new DecimalFormat("##0.0000000");

    public static double getValue() {
        double result = 0.0;
        switch (algrithem) {
            case 1:
                result = algrithemCutCircle();
                break;
            case 2:
                result = algrithemInfiniteSeries();
                break;
        }
        return  Double.parseDouble(fmt.format(result));
    }


    static double algrithemCutCircle() {

        double y = 1.0;
        double pi = 0;
        for (int i = 0; i <= PRECISE_DEGREE_CUT_CIRCLE; i++) {
            pi = 3 * myPow(2, i) * y;
            y = mySqrt(2 - mySqrt(4 - y * y));
        }
        return pi;
    }

    static double algrithemInfiniteSeries() {
        double pi = 0;
        for (int i = 1; i <= PRECISE_DEGREE_INFINITE_SERIES; i++) {
            pi += myPow(-1, i + 1) / (2 * i - 1);
        }
        return (pi * 4);
    }

    public static double myPow(double x, int n) {
        if (n > Integer.MAX_VALUE || n < Integer.MIN_VALUE)
            return 0;
        if (n == 0)
            return 1;
        if (n < 0) {
            return ((1 / x) * myPow(1 / x, -(n + 1)));
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }


   static double mySqrt(double x) {
        if (x == 0) return 0;
        double last = 0.0;
        double res = 1.0;
        while (res != last)
        {
            last = res;
            res = (res + x / res) / 2;
        }
        return res;
    }

    public static boolean setDegree(String degree) {
        switch (degree) {
            case "LOW":
                PRECISE_DEGREE_INFINITE_SERIES = 2000000;
                PRECISE_DEGREE_CUT_CIRCLE = 8;
                degree="LOW";
                fmt=new DecimalFormat("##0.00000");
                break;
            case "MEDIUM":
                PRECISE_DEGREE_INFINITE_SERIES = 40000000;
                PRECISE_DEGREE_CUT_CIRCLE = 12;
                degree="MEDIUM";
                fmt=new DecimalFormat("##0.0000000");
                break;
            case "HIGH":
                PRECISE_DEGREE_INFINITE_SERIES = 500000000;
                PRECISE_DEGREE_CUT_CIRCLE = 15;
                degree="HIGH";
                fmt=new DecimalFormat("##0.0000000000");
                break;
            default:
                return false;
        }
        return true;
    }
}
