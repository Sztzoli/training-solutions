package math;

import java.util.Random;

public class RoundingAnomaly {

    public double[] randomNumbers(int size, double max, int scale) {
        Random rnd = new Random();
        double[] array = new double[size];
        double decimalPoint = Math.pow(10, scale);
        for (int i = 0; i < array.length; i++) {
            double a=rnd.nextDouble()*max;
            array[i] = Math.round(a*decimalPoint)/decimalPoint;
        }
        return array;
    }

    public double roundAfterSum(double[] numbers) {
        double sum = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            sum += numbers[i];
        }

        return Math.round(sum);
    }

    public double sumAfterRound(double[] numbers) {
        double sum = Math.round(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            sum += Math.round(numbers[i]);
        }

        return sum;

    }

    public double difference(int size, double max, int scale) {
        double[] array = randomNumbers(size, max, scale);
        return Math.abs(roundAfterSum(array) - sumAfterRound(array));


    }

    public static void main(String[] args) {


        double sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += new RoundingAnomaly().difference(1000, 1_000_000, 5);
            System.out.println((i + 1) + ":");
            System.out.println(sum / (i + 1));

        }


    }

}
