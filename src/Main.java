import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();

        while (true) {
            printMenu();
            int command = getInput("Введите номер команды:", 1, 4);
            if (command == 1) {
                stepTracker.setCurrStep(getInput("Введите номер месяца (от 0 до 11):", 0, 11),
                        getInput("Введите номер дня (от 1 до 30):", 1, 30),
                        getInput("Введите количество шагов:", 0));
            } else if (command == 2) {
                int month = getInput("Введите номер месяца (от 0 до 11):", 0, 11);
                System.out.println(stepTracker.getStepPerDay(month));
                System.out.println("Общее количество шагов за месяц - " + stepTracker.getTotalStep(month));
                System.out.println("Максимальное пройденное количество шагов в месяце - " + stepTracker.getMaxStep(month));
                System.out.println("Среднее количество шагов - " + stepTracker.getAverageStep(month));
                System.out.println("Пройденная дистанция (в км) - " + Converter.getDistance(stepTracker.getTotalStep(month)));
                System.out.println("Количество сожжённых килокалорий - " + Converter.getKiloCalorie(stepTracker.getTotalStep(month)));
                System.out.println("Лучшая серия - " + stepTracker.getMaxSeries(month) + "\n");
            } else if (command == 3) {
                    stepTracker.setTargetStep(getInput("Введите новую цель по количеству шагов", 0));
            } else if (command == 4) {
                System.out.println("Выход из приложения");
                break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("Список доступных команд:");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения");
    }

    public static int getInput(String message, int minValue){
        while (true) {
            System.out.println(message);
            Scanner scanner = new Scanner(System.in);
            if (!scanner.hasNextInt()) {
                System.out.println("Требуется ввести число!");
                continue;
            }
            int value = scanner.nextInt();
            if (value < minValue) {
                System.out.println("Число должно быть неотрицательным!");
                continue;
            }
            return value;
        }
    }

    public static int getInput(String message, int minValue, int maxValue){
        while (true) {
            System.out.println(message);
            Scanner scanner = new Scanner(System.in);
            if (!scanner.hasNextInt()) {
                System.out.println("Требуется ввести число!");
                continue;
            }
            int value = scanner.nextInt();
            if ((value < minValue) | (value > maxValue)) {
                System.out.println("Неправильный ввод");
                continue;
            }
            return value;
        }
    }
}