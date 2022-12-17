import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();
        StepTracker stepTracker = new StepTracker(); // вызов, для подтягивая методов из класса StepTracker

        while (true) {
            if (userInput == 1) {
                System.out.println("Введите номер месяца, (начиная с нуля): Январь - 0 и т.д.");
                int month = scanner.nextInt();
                System.out.println("Выберите день месяца от 1 до 30 (в месяце у нас ровно 30 дней, даже в феврале)");
                int day = scanner.nextInt();
                System.out.println("Введите количество пройденных шагов");
                int steps = scanner.nextInt();
                stepTracker.saveSteps(month,day, steps);

            } else if (userInput == 2) {
                System.out.println("Введите номер месяца, (начиная с нуля): Январь 0 и т.д.");
                int month = scanner.nextInt();
                stepTracker.printStepsMonth(month);
                System.out.println("Общее количество шагов за месяц: " + stepTracker.findSumSteps(month));
                stepTracker.printMaxStepsMonth(month);
                stepTracker.printAveragedStepsMonth(month);
                stepTracker.printDistanceOnMonth(month);
                stepTracker.printBurnCalories(month);
                System.out.println("Лучшая серия: " + stepTracker.maxSequence(month));

            }else if (userInput == 3) {
                System.out.println("Введите количество шагов:");
                int newGoalSteps = scanner.nextInt();
                stepTracker.changeGoalSteps(newGoalSteps);

            } else if (userInput == 0) {
                System.out.println("Выход");
                break;

            } else {
                System.out.println("К сожалению такой команды нет, выберите существующее действие.");
            }
            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");
    }
    private static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}


