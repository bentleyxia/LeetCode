import java.util.HashMap;

/*
 Implement pow(x, n), which calculates x raised to the power n (xn).
 **Example** 1:
```
Input: 2.00000, 10
Output: 1024.00000
```
 */

public class Pow {

    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == Integer.MIN_VALUE)
            return myPow(x, -Integer.MAX_VALUE) * 1 / x;
        if (n < 0 && n > Integer.MIN_VALUE) {
            n = -n;
            x = 1 / x;
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
    // binary
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        double ans = 1;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                ans = ans * 1 / x;
                n = n + 1;
            }
            n = -n;
            x = 1 / x;
        }
        // if bit is 1, ans * x
        while (n > 0) {
            if ((n & 1) == 1)
                ans = ans * x;
            x = x * x;
            n >>= 1;
        }
        return ans;
    }

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        int flag = 1;
        if (n < 0) {
            n = -n;
            flag = -1;
        }
        String bs = Integer.toBinaryString(n);
        double res = 1;
        double tmp = 0;
        double count = 0;
        for (int i = bs.length() - 1; i > -1; i--) {
            if (i == bs.length() - 1) {
                tmp = x;
            } else
                tmp = tmp * tmp;
            if (Character.getNumericValue(bs.charAt(i)) != 0)
                res = res * tmp;
        }
        if (flag == 1)
            return res;
        else
            return 1 / res;
        ;
    }
}