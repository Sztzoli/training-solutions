package week02;

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

    public static void main(String[] args) {
        Product product1=new Product("alma","1234");
        Product product2=new Product("körte","3456");
        Product product3=new Product("alma","12345");

        System.out.println(product1.areTheyEqual(product2));
        System.out.println(product1.areTheyEqual(product3));


    }
}
