package exam03;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;


public class Cruise {
    private Boat boat;
    private LocalDate sailing;
    private double basicPrice;
    private List<Passenger> passengers = new ArrayList<>();

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }


    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    private void overBook() {
        if (boat.getMaxPassengers() < passengers.size() + 1) {
            throw new IllegalArgumentException("No more free place");
        }
    }

    public void bookPassenger(Passenger passenger) {
        overBook();
        passengers.add(passenger);
    }

    public List<Passenger> getPassengers() {
        return new ArrayList<>(passengers);
    }


    public double getPriceForPassenger(Passenger passenger) {
        return this.basicPrice * passenger.getCruiseClass().getLuxuryPrice();
    }

    public Passenger findPassengerByName(String name) {
        return passengers.stream()
                .filter(x -> x.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Not found"));
    }

    public List<String> getPassengerNamesOrdered() {
        return passengers.stream()
                .map(Passenger::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    public double sumAllBookingsCharged() {
        return passengers.stream()
                .flatMapToDouble(x -> DoubleStream.of(getPriceForPassenger(x)))
                .sum();
    }


    public Map<CruiseClass, Integer> countPassengerByClass() {
        Map<CruiseClass, Integer> result = new HashMap<>();
        for (Passenger passenger : passengers) {
            CruiseClass type = passenger.getCruiseClass();
            if (result.containsKey(type)) {
                result.put(type, result.get(type) + 1);
            } else {
                result.put(type, 1);
            }
        }
        return result;
//        return passengers.stream()
//                .map(Passenger::getCruiseClass)
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
