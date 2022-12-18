public class  Converter {
    double oneStep; // один шаг в см, не забыть при расчетах, так как в итоге километры
    int oneStepCalories; //трата калорий при одном шаге

    public Converter(double oneStep, int oneStepCalories) {
    this.oneStep = oneStep;
    this.oneStepCalories = oneStepCalories;
    }
    double convertStepsInKm(int stepsTotal) {
        return stepsTotal * oneStep / 100000;
    }

    int convertCalories(int stepsTotal) {
        return stepsTotal * oneStepCalories / 1000;
    }
}