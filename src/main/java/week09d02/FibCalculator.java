package week09d02;


public class FibCalculator {


    public long sumEvents(int bound) {
        int a = 0;
        int b = 1;
        int sum = 0;

        while (b < bound) {
            sum += b%2==0 ? b : 0;
            int temp = a + b;
            a = b;
            b = temp;
        }
        return sum;


    }

    public long sumEvents2(int bound){
        int n=1;
         long sum=0;
        while (fibRecurz(n)<bound){
            if (fibRecurz(n)%2==0) {
                sum+=fibRecurz(n);
            }
            n++;
        }
        return sum;
    }

    private static long fibRecurz(int n) {
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

    private static final Long[] RESULT = new Long[1000];

}
