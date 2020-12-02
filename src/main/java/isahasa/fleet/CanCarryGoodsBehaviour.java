package isahasa.fleet;

public class CanCarryGoodsBehaviour implements CanCarryGoods {
    private int cargoWeight;
    private int maxCargoWeight;


    public CanCarryGoodsBehaviour(int maxCargoWeight) {
        this.maxCargoWeight = maxCargoWeight;
    }

    @Override
    public int loadCargo(int cargoWeight) {
        int leftWeight = 0;
        if (cargoWeight <= maxCargoWeight) {
            this.cargoWeight = cargoWeight;
        } else {
            leftWeight = cargoWeight - maxCargoWeight;
            this.cargoWeight = maxCargoWeight;
        }
        return leftWeight;
    }

    @Override
    public int getCargoWeight() {
        return cargoWeight;
    }
}
