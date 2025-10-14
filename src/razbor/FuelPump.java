package razbor;

class FuelPump {
    private int power; // условная мощность 0..100

    public FuelPump(int power) {
        if (power < 0) power = 0;
        if (power > 200) power = 200; // мягкий предел
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}
