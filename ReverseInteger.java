public class ReverseInteger {
    public int reverse(int x) {
        boolean isNegative = false;

        if (x < 0) {
            isNegative = true;
            x *= -1;
        }

        long res = 0;
        while (x > 0) {
            res = (res * 10) + (x % 10);
            x /= 10;
            if (res > Integer.MAX_VALUE) {
                return 0;
            }
        }

        return isNegative ? (int) -res : (int) res;
    }
}
