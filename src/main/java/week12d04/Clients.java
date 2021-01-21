package week12d04;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Clients {

    private Map<String, Client> clientMap = new HashMap<>();

    public Clients(Client... clients) {
        for (Client client : clients) {
            clientMap.put(client.getRegNumber(), client);
        }
    }


    public Client findByRegNumber(String regNumber) {
        if (clientMap.containsKey(regNumber)) {
            return clientMap.get(regNumber);
        }
        throw new IllegalArgumentException("Client this regNumber: " + regNumber + " is not found");
    }

    public List<Client> findByName(String nameFragment) {
        return clientMap.values().stream()
                .filter(client -> client.getName().contains(nameFragment))
                .collect(Collectors.toList());
    }

    public Map<String, Client> getClientMap() {
        return new HashMap<>(clientMap);
    }
}
