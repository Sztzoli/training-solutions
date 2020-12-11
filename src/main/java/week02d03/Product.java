package week02d03;

public class Product {
    private String name;

    private String code;

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Product(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public boolean areTheyEqual(Product anotherProduct) {

        return name.equals(anotherProduct.name);
    }
    public boolean areTheyEqual2(Product anotherProduct) {

        return name.equals(anotherProduct.name) && Math.abs(code.length()-anotherProduct.code.length())<=1;
    }


    public static void main(String[] args) {
        Product product1=new Product("alma","1234");
        Product product2=new Product("körte","3456");
        Product product3=new Product("alma","123456");

        System.out.println(product1.areTheyEqual(product2));
        System.out.println(product1.areTheyEqual(product3));
        System.out.println(product1.areTheyEqual2(product3));


    }
}
