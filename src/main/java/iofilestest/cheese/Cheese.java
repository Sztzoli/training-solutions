package iofilestest.cheese;

import java.util.Objects;

public class Cheese {
    private final String name;
    private final double lactoseContent;

    public Cheese(String name, double lactoseContent) {
        this.name = name;
        this.lactoseContent = lactoseContent;
    }

    public String getName() {
        return name;
    }

    public double getLactoseContent() {
        return lactoseContent;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cheese cheese = (Cheese) o;
        return Double.compare(cheese.lactoseContent, lactoseContent) == 0 && Objects.equals(name, cheese.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lactoseContent);
    }
}
