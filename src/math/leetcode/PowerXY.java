package math.leetcode;

public class PowerXY {
    public double myPow(double x, int y) {
        if(y > 0) return power(x,Math.abs(y));
        return 1.0 / power(x,Math.abs(y));
    }

    public double power(double x, int y) {
        if(y == 0) return 1;
        double temp = power(x, y/2);
        return temp * temp * (y % 2 == 0 ? 1.0 : x);
    }
}
