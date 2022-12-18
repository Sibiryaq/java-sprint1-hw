import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(); // вызов, для подтягивая методов из класса StepTracker

        while (true) {
            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            int userInput = scanner.nextInt(); // повторное считывание данных от пользователя

            if (userInput == 1) {
                stepTracker.saveSteps();

            } else if (userInput == 2) {
                stepTracker.getStatistic();

            }else if (userInput == 3) {
                stepTracker.changeGoalSteps();

            } else if (userInput == 0) {
                System.out.println("Выход");
                break;

            } else {
                System.out.println("К сожалению такой команды нет, выберите существующее действие.");
            }
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


