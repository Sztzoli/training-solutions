package lambdaintermediate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {

    private List<CoffeeOrder> orders = new ArrayList<>();

    public Cafe(List<CoffeeOrder> orders) {
        this.orders = orders;
    }

    public void add(CoffeeOrder order) {
        orders.add(order);
    }


    public BigDecimal getTotalIncome() {
        return orders.stream()
                .flatMap(order -> order.getCoffeeList().stream())
                .map(Coffee::getPrice)
                .reduce(BigDecimal.ZERO,
                        BigDecimal::add,
                        (bd1, bd2) -> bd1.add(bd2)).setScale(2, RoundingMode.HALF_UP);

    }

    public BigDecimal getTotalIncome(LocalDate date) {
        return orders.stream()
                .filter(order -> order.getDateTime().toLocalDate().equals(date))
                .flatMap(order -> order.getCoffeeList().stream())
                .map(Coffee::getPrice)
                .reduce(BigDecimal.ZERO,
                        BigDecimal::add,
                        (bd1, bd2) -> bd1.add(bd2)).setScale(2, RoundingMode.HALF_UP);

    }

    public long getNumberOfCoffee(CoffeeType type) {
        return orders.stream()
                .flatMap(order -> order.getCoffeeList().stream())
                .filter(coffee -> coffee.getType()==type)
                .count();
    }

    public List<CoffeeOrder> getOrdersAfter(LocalDateTime dateTime) {
        return orders.stream()
                .filter(order -> order.getDateTime().isAfter(dateTime))
                .collect(Collectors.toList());
    }

    public List<CoffeeOrder> getFirstFiveOrder(LocalDate localDate) {
        return orders.stream()
                .filter(order -> order.getDateTime().toLocalDate().equals(localDate))
                .sorted(Comparator.comparing(CoffeeOrder::getDateTime))
                .limit(5)
                .collect(Collectors.toList());
    }
}
