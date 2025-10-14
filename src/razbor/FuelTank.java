package razbor;

class FuelTank {
    private int capacityLiters;
    private double currentLiters;

    public FuelTank(int capacityLiters) {
        if (capacityLiters < 1) capacityLiters = 1;
        this.capacityLiters = capacityLiters;
        this.currentLiters = 0.0;
    }

    // Перегрузка: долить фиксированное количество литров
    public void refuel(int liters) {
        if (liters <= 0) return;
        currentLiters += liters;
        if (currentLiters > capacityLiters) currentLiters = capacityLiters;
    }

    // Перегрузка: долить долю от максимума, например 0.25 = +25% от capacity
    public void refuel(double fractionOfCapacity) {
        if (fractionOfCapacity <= 0) return;
        double add = capacityLiters * fractionOfCapacity;
        currentLiters += add;
        if (currentLiters > capacityLiters) currentLiters = capacityLiters;
    }

    public void consume(double liters) {
        if (liters <= 0) return;
        currentLiters -= liters;
        if (currentLiters < 0) currentLiters = 0;
    }

    public int getCapacityLiters() {
        return capacityLiters;
    }

    public double getCurrentLiters() {
        return currentLiters;
    }
}
