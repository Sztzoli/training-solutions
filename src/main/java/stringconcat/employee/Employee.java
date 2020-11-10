package stringconcat.employee;

public class Employee {

    private String name;
    private String position;
    private int salary;

    public Employee(String name, String position, int salary) {
        if (name == null || name.equals("") ) {
            throw new IllegalArgumentException("rossz név");
        }
        if (position == null || position.equals("") ) {
            throw new IllegalArgumentException("rossz pozició");
        }
        if (salary%1000!=0 || salary<0){
            throw new IllegalArgumentException("rossz fizetés");
        }
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " - "+ position +" - "+salary;
    }
}
