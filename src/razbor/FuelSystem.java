package razbor;

class FuelSystem {
    private FuelTank tank;
    private FuelPump pump;
    private FuelRail rail;
    private Injector[] injectors;
    private int injectorCount = 0;

    public FuelSystem(FuelTank tank, FuelPump pump, FuelRail rail, int injectorCapacity) {
        this.tank = tank;
        this.pump = pump;
        this.rail = rail;
        if (injectorCapacity < 1) injectorCapacity = 1;
        this.injectors = new Injector[injectorCapacity];
    }

    // Перегрузка
    public void addInjector(Injector inj) {
        if (inj == null) return;
        if (injectorCount >= injectors.length) return;
        injectors[injectorCount++] = inj;
    }

    public void addInjector(int throughput) {
        addInjector(new Injector(throughput));
    }

    public int getInjectorCount() {
        return injectorCount;
    }

    public FuelTank getTank() {
        return tank;
    }

    public FuelPump getPump() {
        return pump;
    }

    public FuelRail getRail() {
        return rail;
    }
}
