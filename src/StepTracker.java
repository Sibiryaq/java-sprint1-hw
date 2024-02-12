import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    Converter converter = new Converter();
    MonthData[] monthData = new MonthData[12];
    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthData.length; i++) {
            monthData[i] = new MonthData();
        }
    }

    void changeStepGoal() {
        int newGoalOfSteps = setCountSteps();
        if (newGoalOfSteps <= 0) {
            System.out.println("Цель шагов должно быть больше 0!");
        } else {
            goalByStepsPerDay = newGoalOfSteps;
            System.out.println("Новая цель: " + goalByStepsPerDay);
        }
    }

    void addNewNumberStepsPerDay() {
        MonthData monthDataObj = monthData[setMonth() - 1];
        monthDataObj.days[setDay() - 1] = setCountSteps();
    }

    void printStatistic() {
        int month = setMonth();
        MonthData monthDataObj = monthData[month - 1];

        System.out.println("Вывод общей статистики по дням: ");
        monthDataObj.printDaysAndStepsFromMonth();
        System.out.println("Сумма шагов за месяц: " + monthDataObj.sumStepsFromMonth());
        System.out.println("Максимальное пройденное количества шагов за месяц: " + monthDataObj.maxSteps());
        System.out.println("Cреднее пройденное количество шагов за месяц: " + (monthDataObj.sumStepsFromMonth() / 30));
        System.out.println("Вывод пройденной за месяц дистанции в км: "
                + converter.convertToKm(monthDataObj.sumStepsFromMonth()));
        System.out.println("Вывод количества сожжённых килокалорий за месяц: "
                + converter.convertStepsToKilocalories(monthDataObj.sumStepsFromMonth()));
        System.out.println("Вывод лучшей серии: " + monthDataObj.bestSeries(goalByStepsPerDay));
        System.out.println();
    }

    int setMonth() {
        System.out.println("Введите номер месяца от 1 до 12");

        while (true) {
            int month = scanner.nextInt();
            if (month < 1 || month > 12) {
                System.out.println("Номер вводимого месяца должен быть от 1 до 12 включительно");
            } else {
                return month;
            }
        }

    }

    int setDay() {
        System.out.println("Введите день от 1 до 30 (включительно)");

        while (true) {
            int day = scanner.nextInt();
            if (day < 1 || day > 30) {
                System.out.println("Номер вводимого дня должен быть от 1 до 30 включительно");
            } else {
                return day;
            }
        }

    }

    int setCountSteps() {
        System.out.println("И количество шагов:");

        while (true) {
            int countSteps = scanner.nextInt();
            if (countSteps <= 0) {
                System.out.println("Количество шагов должно быть положительным числом");
            } else {
                return countSteps;
            }
        }

    }

}


