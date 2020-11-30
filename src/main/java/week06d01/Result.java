package week06d01;

public class Result {
    private double positiveSum;
    private double negativeSum;

    public double getPositiveSum() {
        return positiveSum;
    }

    public double getNegativeSum() {
        return negativeSum;
    }

    public void add(double number){
        if (number>0){
            positiveSum+=number;
        } else {
            negativeSum+=number;
        }


    }


}
