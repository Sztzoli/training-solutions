package week07d01;

public class Fibonacci {

    public long fib(int n) {
        long a = 0;
        long b = 1;

        if (n == 0) {
            return a;
        }
        if (n == 1) {
            return b;
        }
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                a += b;
            } else {
                b += a;
            }
        }
        return n % 2 == 0 ? a : b;
    }

    public static long fibRecurz(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Counter can't be less then 0");
        }

        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        if (RESULT[n] == null) {
            RESULT[n] = fibRecurz(n - 1) + fibRecurz(n - 2);
        }

        return RESULT[n];


    }

    private static final Long[] RESULT = new Long[Integer.MAX_VALUE];

}
