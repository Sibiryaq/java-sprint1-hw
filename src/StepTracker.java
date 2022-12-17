public class StepTracker {
    int [][] monthData = new int[12][30]; //так как тип данных int, то весь массив сам заполнится нулями
    int goalSteps = 10000; //обычная цель - 10000 в день
    Сonverter converter = new Сonverter(); //вызов для 2ух методов внизу

    void changeGoalSteps(int newGoalSteps) {  //вроде логика присутствует?? все ок?
        if (newGoalSteps > 0) {
            goalSteps = newGoalSteps;
            System.out.println("Ваша новая цель, с которой вы обязательно справитесь: " + goalSteps);
        } else {
            System.out.println("Данные не могут быть отрицательными.");
        }
    }
    void saveSteps(int month, int day, int steps) {  // Сохранение количества шагов за день
        if (steps > 0) {
            monthData[month][day] = steps;
            System.out.println(monthData[month][day] + " - Данные внесены!");
        } else {
            System.out.println("Данные не могут быть отрицательными.");
        }

    }
    void printStepsMonth(int month) { // Количество пройденных шагов по дням в следующем формате
            for(int i = 0; i < monthData[month].length; i++) {
                System.out.println((i + 1) + " день: " + monthData[month][i] + ",");
            }
    }

    int findSumSteps(int month) { // Общее количество шагов за месяц
        int sum = 0;
        for (int i = 0; i < monthData[month].length; i++) {
            sum = sum + monthData[month][i];
        }
        return sum;
    }
    void printMaxStepsMonth(int month) { //Максимальное пройденное количество шагов в месяце;
        int maxSteps = 0;
        for (int i = 0; i < monthData[month].length; i++) {
            if (monthData[month][i] > maxSteps) {
                maxSteps = monthData[month][i];
            }
        }
        System.out.println("Максимальное количество шагов: " + maxSteps);
    }

    void printAveragedStepsMonth(int month) {  // Среднее количество шагов
        int sum = findSumSteps(month);
        System.out.println("Среднее количество шагов: " + (sum / 30));

    }

    void printBurnCalories(int month) {
        int stepsTotal = findSumSteps(month);
        converter.convertCalories(stepsTotal);
        System.out.println("Количество сожженных килокалорий: " + converter.convertCalories(stepsTotal) + " Ккал");
    }

    void printDistanceOnMonth(int month) {
        int stepsTotal = findSumSteps(month);
        converter.convertStepsInKm(stepsTotal);
        System.out.println("Пройденная дистанция: " + converter.convertStepsInKm(stepsTotal) + " км");
    }

    int maxSequence(int month) { /* Максимальное количество подряд идущих дней, в
                                    течение которых количество шагов за день было
                                    равно или выше целевого */
      int max = 0;
      int predmax = 0;
      for (int i = 0; i < monthData[month].length; i++) {
          if (monthData[month][i] >= goalSteps) {
              predmax = predmax + 1;
          } else if (predmax > max) {
              max = predmax;
              predmax = 0;
          }
      }
      return max;

    }
}



