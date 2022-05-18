package DAY3;

// tags : Implementation , Algorithms , Medium
public class powXn {

    // use exponentiation algo
    public double myPow(double x, int n) {
        double res = 1.00;
        int pow = Math.abs(n);
        while (pow != 0) {
            if (pow % 2 != 0) {
                // in negative power we will divide by 1/x
                res = n > 0 ? res * x : res * (1 / x);
                n--;
            }
            pow /= 2;
            x *= x;
        }
        return res;
    }

}
