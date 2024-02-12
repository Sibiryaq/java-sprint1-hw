public class Converter {
    int smInOneStep = 75;
    int callInOneStep = 50;

    int convertToKm(int steps) {
        return (steps * smInOneStep) / 100000;
    }

    int convertStepsToKilocalories(int steps) {
        return (steps * callInOneStep) / 1000;
    }
}
