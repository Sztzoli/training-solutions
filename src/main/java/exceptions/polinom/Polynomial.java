package exceptions.polinom;

public class Polynomial {

    private double[] coefficients;

    public Polynomial(double[] coefficients) {
        if (coefficients==null) {
            throw new NullPointerException("coefficients is null");
        }
        this.coefficients = coefficients;
    }

    public Polynomial(String[] coefficients) {
        if (coefficients==null) {
            throw new NullPointerException("coefficientStrs is null");
        }


        try {
            this.coefficients = convert(coefficients);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Illegal coefficients, not a number", e);
        }
    }

    public double[] convert(String [] coefficients) {
        double[] array= new double[coefficients.length];
        for (int i = 0; i < coefficients.length; i++) {

            array[i] = Double.parseDouble(coefficients[i]);

        }
        return array;
    }


    public double evaluate(double x) {
        double sum=0;
        for (int i = 0; i < coefficients.length; i++) {
            sum +=  (coefficients[i] * Math.pow(x,coefficients.length-1-i));
        }
        return sum;
    }

    public double[] getCoefficients() {
        return coefficients;
    }
}
