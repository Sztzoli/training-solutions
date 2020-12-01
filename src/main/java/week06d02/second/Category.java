package week06d02.second;

public enum Category {
    FROZEN(0),
    DAIRY(0),
    BAKEDGOODS(0),
    OTHER(0);

    private int pieces;

    Category(int pieces) {
        this.pieces = pieces;

    }

    public void pieceAdd(Category category) {
        category.pieces++;
    }

    public int getPieces() {
        return pieces;
    }
}
