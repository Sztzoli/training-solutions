package classstructuremethods;

public class ClientMain {
    public static void main(String[] args) {
        Client client = new Client();
        client.setName("John Doe");
        client.setYeorOfBirth(1989);
        client.setAddress("Kis Pista");
        System.out.println(client.getName() +" born: " + client.getYeorOfBirth() + " ,address: " + client.getAddress());

        client.migrate("Nagy János");
        System.out.println(client.getName() +" born: " + client.getYeorOfBirth() + " ,address: " + client.getAddress());
    }
}
