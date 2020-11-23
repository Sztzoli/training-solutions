package methodvarargs;

public class ExamStats {
    private final int maxPoints;


    public ExamStats(int maxPoints){
        this.maxPoints=maxPoints;
    }
    public int getNumberOfTopGrades(int limitInPercent, int... results){
        if (results==null || results.length==0){
            throw new IllegalArgumentException("Number of results must not be empty!");
        }
        int count=0;
        for (int result : results ) {
            if (result> maxPoints*limitInPercent/100d){
                count++;
            }
        }
        return count;
    }
    public boolean hasAnyFailed(int limitInPercent, int... results){
        if (results==null || results.length==0){
            throw new IllegalArgumentException("Number of results must not be empty!");
        }
        for (int result : results) {
            if(result< maxPoints*limitInPercent/100d){
                return true;
            }
        }
        return false;
    }
}
