package razbor;

class FuelRail {
    private int pressure; // условное давление 0..200

    public FuelRail(int pressure) {
        if (pressure < 0) pressure = 0;
        if (pressure > 200) pressure = 200;
        this.pressure = pressure;
    }

    public int getPressure() {
        return pressure;
    }
}
