public class  Сonverter {
    int oneStep = 75; // один шаг в см, не забыть при расчетах, так как в итоге километры
    int oneStepCalories = 50; //трата калорий при одном шаге
    double convertStepsInKm(int stepsTotal) {
        return stepsTotal * oneStep / 100000;
    }

    double convertCalories(int stepsTotal) {
        return stepsTotal * oneStepCalories / 1000;
    }
}