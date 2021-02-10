package week15d02;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PizzaOrder {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    private Map<LocalDate, Map<String, List<OrderAddress>>> pizzaOrders = new HashMap<>();


    public PizzaOrder(BufferedReader reader) {
        readFile(reader);
    }

    private void readFile(BufferedReader reader) {


        try (reader) {
            String line = reader.readLine();

            while (line != null) {
                LocalDate date = LocalDate.parse(line, formatter);
                line = reader.readLine();
                Map<String, List<OrderAddress>> oneDayOrder = new HashMap<>();
                while (line != null && line.startsWith("FUT")) {

                    String deliveryBoy = line;
                    String[] orderAddressParts = reader.readLine().split(" ");
                    Order order =
                            new Order(deliveryBoy,
                                    new OrderAddress(orderAddressParts[0],
                                            orderAddressParts[1],
                                            orderAddressParts[2],
                                            LocalTime.parse(orderAddressParts[3])));
                    oneDayOrder.merge(
                            order.getDelivery(),
                            List.of(order.getOrderAddress()),
                            (v1, v2) -> {
                                List<OrderAddress> list = new ArrayList<>(v1);
                                list.add(v2.get(0));
                                return list;
                            }
                    );
                    line = reader.readLine();
                }
                pizzaOrders.put(date, oneDayOrder);

            }
        } catch (IOException ioException) {
            throw new IllegalStateException("File cannot read", ioException);
        }
    }

    public LocalDate minOrderByDate() {
        Optional<LocalDate> result =
                pizzaOrders.keySet().stream().
                        min(Comparator.comparing(v -> pizzaOrders.get(v).values().stream().mapToInt(List::size).sum()));
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new IllegalArgumentException("map is empty");
        }


    }

    public OrderAddress findOrderByDateTime(LocalDateTime localDateTime) {
        LocalDate date = localDateTime.toLocalDate();
        if (pizzaOrders.containsKey(date)) {
            Optional<OrderAddress> result =

                    pizzaOrders.get(date).values().stream().
                            flatMap(Collection::stream).
                            filter(orderAddress -> orderAddress.getDeliveryTime().equals(localDateTime.toLocalTime())).
                            findAny();

            if (result.isPresent()) {
                return result.get();
            } else {
                throw new IllegalArgumentException("not? found");
            }
        } else {
            throw new IllegalArgumentException("not found");
        }
    }

    public long numberOfCompletedDelivery(String deliveryBoy) {
        return pizzaOrders.values().stream().
                filter(x -> x.containsKey(deliveryBoy)).
                flatMap(y -> y.keySet().stream()).
                filter(x -> x.contains(deliveryBoy)).
                count();
    }

    public String maxAddress() {
        Optional <Map.Entry<String, Long>> result =
                addressMap().entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue));

        if(result.isPresent()) {
            return result.get().getKey();
        }
        else {
            throw new IllegalStateException("List is empty");
        }
    }

   private Map<String, Long> addressMap() {
        return pizzaOrders.values().stream()
                .flatMap(x -> x.values().stream())
                .flatMap(Collection::stream)
                .collect(
                        Collectors.groupingBy(OrderAddress::getStreet, Collectors.counting()));
   }


    public static void main(String[] args) throws IOException {
        Path file = Path.of("src/main/java/week15d02/orders.txt");
        PizzaOrder pizzaOrder = new PizzaOrder(Files.newBufferedReader(file, StandardCharsets.UTF_8));
        System.out.println(pizzaOrder.pizzaOrders);
        System.out.println(pizzaOrder.minOrderByDate());
        System.out.println(pizzaOrder.findOrderByDateTime(LocalDateTime.of(2020, 12, 1, 12, 30)));
        System.out.println(pizzaOrder.numberOfCompletedDelivery("FUT_4"));
        System.out.println(pizzaOrder.maxAddress());
    }

}
