package razbor;

class Engine {
    private Piston[] pistons;
    private int pistonCount = 0;

    private Cylinder[] cylinders;
    private int cylinderCount = 0;

    public Engine(int pistonCapacity, int cylinderCapacity) {
        if (pistonCapacity < 1) pistonCapacity = 1;
        if (cylinderCapacity < 1) cylinderCapacity = 1;
        this.pistons = new Piston[pistonCapacity];
        this.cylinders = new Cylinder[cylinderCapacity];
    }

    // Перегрузка: добавить готовый объект
    public void addPiston(Piston p) {
        if (p == null) return;
        if (pistonCount >= pistons.length) return;
        pistons[pistonCount++] = p;
    }

    // Перегрузка: создать внутри
    public void addPiston(int motoMinutes, String material) {
        addPiston(new Piston(motoMinutes, material));
    }

    public void addCylinder(Cylinder c) {
        if (c == null) return;
        if (cylinderCount >= cylinders.length) return;
        cylinders[cylinderCount++] = c;
    }

    public void wearOneMinute() {
        for (int i = 0; i < pistonCount; i++) {
            pistons[i].useOneMinute();
        }
        for (int i = 0; i < cylinderCount; i++) {
            cylinders[i].useOneMinute();
        }
    }

    public void accumulateShavings(double amountPerCylinder) {
        if (amountPerCylinder <= 0) return;
        for (int i = 0; i < cylinderCount; i++) {
            cylinders[i].addShavings(amountPerCylinder);
        }
    }

    public int minPistonHours() {
        // возвращаем минимальные оставшиеся мотоминуты поршней (как «прочность»), переведём в часы
        if (pistonCount == 0) return 0;
        int min = pistons[0].getRemainingMinutes();
        for (int i = 1; i < pistonCount; i++) {
            if (pistons[i].getRemainingMinutes() < min) min = pistons[i].getRemainingMinutes();
        }
        return min / 60;
    }

    public int minCylinderHours() {
        if (cylinderCount == 0) return 0;
        int min = cylinders[0].getRemainingMinutes();
        for (int i = 1; i < cylinderCount; i++) {
            if (cylinders[i].getRemainingMinutes() < min) min = cylinders[i].getRemainingMinutes();
        }
        return min / 60;
    }

    public double avgCylinderShavings() {
        if (cylinderCount == 0) return 0.0;
        double sum = 0.0;
        for (int i = 0; i < cylinderCount; i++) {
            sum += cylinders[i].getShavings();
        }
        return sum / cylinderCount;
    }
}