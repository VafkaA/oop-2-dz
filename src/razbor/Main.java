package razbor;

public class Main {
    public static void main(String[] args) {
        // Создаём двигатель: 4 поршня, 4 цилиндра
        Engine engine = new Engine(4, 4);
        engine.addPiston(5000, "Aluminum");
        engine.addPiston(5000, "Aluminum");
        engine.addPiston(5000, "Aluminum");
        engine.addPiston(5000, "Aluminum");

        engine.addCylinder(new Cylinder(6000, "Steel"));
        engine.addCylinder(new Cylinder(6000, "Steel"));
        engine.addCylinder(new Cylinder(6000, "Steel"));
        engine.addCylinder(new Cylinder(6000, "Steel"));

        // Создаём топливную систему: бак 50 л, насос 100 ед, рампа 120 ед, 4 форсунки
        FuelTank tank = new FuelTank(50);
        FuelPump pump = new FuelPump(100);
        FuelRail rail = new FuelRail(120);
        FuelSystem fuel = new FuelSystem(tank, pump, rail, 4);
        fuel.addInjector(30);
        fuel.addInjector(30);
        fuel.addInjector(30);
        fuel.addInjector(30);

        // Машина
        Car car = new Car(engine, fuel);

        // Заправимся на 60% от максимума
        fuel.getTank().refuel(0.6);

        // Покатаемся 90 минут
        car.run(90);

        // Выводим состояние
        System.out.println("=== Итоги поездки ===");
        System.out.println("Топливо в баке (л): " + fuel.getTank().getCurrentLiters());
        System.out.println("Оставшиеся моточасы поршней: " + engine.minPistonHours());
        System.out.println("Оставшиеся моточасы цилиндров: " + engine.minCylinderHours());
        System.out.println("Средняя стружка в цилиндрах: " + engine.avgCylinderShavings());
    }
}
