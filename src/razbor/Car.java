package razbor;

class Car {
    private Engine engine;
    private FuelSystem fuel;

    public Car(Engine engine, FuelSystem fuel) {
        this.engine = engine;
        this.fuel = fuel;
    }

    // minutes — сколько минут работаем
    // Простая модель расхода: расход/мин = база * кол-во форсунок * коэффициенты насоса/рампы
    public void run(int minutes) {
        if (minutes <= 0) return;
        int injectors = fuel.getInjectorCount();
        // базовый расход топлива в литрах за минуту (очень упрощённо)
        double basePerMin = 0.01; // 0.01 л/мин на форсунку при средних параметрах
        double pumpCoeff = fuel.getPump().getPower() / 100.0; // 1.0 при 100
        double railCoeff = fuel.getRail().getPressure() / 120.0; // 1.0 при 120
        double perMin = basePerMin * injectors * pumpCoeff * railCoeff;

        for (int m = 0; m < minutes; m++) {
            // если топлива недостаточно — прекращаем
            if (fuel.getTank().getCurrentLiters() < perMin) break;

            // тратим топливо
            fuel.getTank().consume(perMin);

            // старение деталей: у каждого поршня/цилиндра -1 мотоминут (мотоЧАСЫ считаем в минутах для простоты)
            engine.wearOneMinute();

            // накапливаем стружку в цилиндрах (упрощённо): зависит от нагрузки (perMin)
            engine.accumulateShavings(perMin * 0.1);
        }
    }
}