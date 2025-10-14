package razbor;

class Cylinder {
    private int remainingMinutes; // «заложенные моточасы» в минутах
    private String material;
    private double shavings; // стружка/износ

    public Cylinder(int motoMinutes, String material) {
        if (motoMinutes < 0) motoMinutes = 0;
        this.remainingMinutes = motoMinutes;
        this.material = material == null ? "" : material;
        this.shavings = 0.0;
    }

    public void useOneMinute() {
        if (remainingMinutes > 0) remainingMinutes -= 1;
    }

    public void addShavings(double amount) {
        if (amount <= 0) return;
        shavings += amount;
    }

    public int getRemainingMinutes() {
        return remainingMinutes;
    }

    public String getMaterial() {
        return material;
    }

    public double getShavings() {
        return shavings;
    }
}
