package exceptionmulticatch.converter;



public class AnswerStat {



    private BinaryStringConverter converter;

    public AnswerStat(BinaryStringConverter converter) {
        this.converter = converter;
    }

    public boolean[] convert(String str) {
        try {
            return converter.binaryStringToBooleanArray(str);
        } catch (NullPointerException | IllegalArgumentException e) {
            throw new InvalidBinaryStringException("binaryString not valid");
        }
    }

    public int answerTruePercent(String answers) {
        boolean[] array = new boolean[answers.length()];
        try {
            array=converter.binaryStringToBooleanArray(answers);
        } catch (NullPointerException | IllegalArgumentException e) {
            throw new InvalidBinaryStringException("binaryString not valid");
        }
        return answerTruePercent(array);
    }

    private int answerTruePercent(boolean[] array) {
        int count=0;
        for (boolean b : array) {
            if (b) {
                count++;
            }
        }
        return (int)Math.round(count/(double)array.length*100);
    }
}
