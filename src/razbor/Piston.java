package razbor;

class Piston {
    private int remainingMinutes; // «заложенные моточасы» в минутах
    private String material;

    public Piston(int motoMinutes, String material) {
        if (motoMinutes < 0) motoMinutes = 0;
        this.remainingMinutes = motoMinutes;
        this.material = material == null ? "" : material;
    }

    public void useOneMinute() {
        if (remainingMinutes > 0) remainingMinutes -= 1;
    }

    public int getRemainingMinutes() {
        return remainingMinutes;
    }

    public String getMaterial() {
        return material;
    }
}