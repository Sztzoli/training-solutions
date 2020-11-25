package staticattrmeth;

import java.math.BigDecimal;

public class BankTransaction {
    private static final long MIN_TRX_VALUE = 1;
    private static final long MAX_TRX_VALUE = 10_000_000;
    private static long currentMinValue;
    private static long currentMaxValue;
    private static BigDecimal sumOfTrxs;
    private static int numberOfBankTransaction;


    private long trxValue;


    public static void initTheDay() {
        numberOfBankTransaction = 0;
        sumOfTrxs = new BigDecimal("0");
        currentMaxValue = 0;
        currentMinValue = 0;
    }

    public static BigDecimal averageOfTransaction() {
        return sumOfTrxs.divide(new BigDecimal(Long.toString(numberOfBankTransaction)));
    }


    public static long getCurrentMinValue() {
        return currentMinValue;
    }

    public static long getCurrentMaxValue() {
        return currentMaxValue;
    }

    public static BigDecimal getSumOfTrxs() {

        return sumOfTrxs;
    }

    public BankTransaction(long trxValue) {
        this.trxValue = trxValue;
        if(numberOfBankTransaction==0){
            currentMinValue = trxValue;
            currentMaxValue = trxValue;
        }

        numberOfBankTransaction++;

        if (currentMinValue > trxValue) {
            currentMinValue = trxValue;
        }
        if (currentMaxValue < trxValue) {
            currentMaxValue = trxValue;
        }
        sumOfTrxs = sumOfTrxs.add(new  BigDecimal(Long.toString(trxValue)));

    }

    public long getTrxValue() {
        return trxValue;
    }
}
