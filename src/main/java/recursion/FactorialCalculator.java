package recursion;

public class FactorialCalculator {

    public long getFactorial(int number) {
        if(number>1){
            long solution = getFactorial(number-1);
            return number*solution;
        } else {
            return 1;
        }
    }

    public long getFactorialIt(int number) {
        long solution=1;
        for (int i = 1; i <= number; i++) {
            solution*=i;
        }
    return solution;
    }
}
