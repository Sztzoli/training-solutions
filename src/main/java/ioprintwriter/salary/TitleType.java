package ioprintwriter.salary;

public enum TitleType {
    DR (500_000),
    MR_OR_MRS (200_000),
    ELSE (100_000);

    private int salary;

    TitleType(int salary) {
        this.salary = salary;
    }

    public static TitleType type(String name) {
        if (name.startsWith("Dr")){
            return TitleType.DR;
        }
        if (name.startsWith("Mr") || name.startsWith("Mrs")) {
            return TitleType.MR_OR_MRS;
        }
        else {
            return TitleType.ELSE;
        }
    }

    public int getSalary() {
        return salary;
    }
}
