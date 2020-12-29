package clone.issuetracker;

public enum CopyMode {
    WITHOUT_COMMENTS,
    WITH_COMMENTS;

    public boolean isWithout(CopyMode copyMode){
        if (copyMode==WITHOUT_COMMENTS){
            return true;
        }
        return false;
    }
}
