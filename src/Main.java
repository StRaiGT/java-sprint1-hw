import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                System.out.println("Введите номер месяца (от 0 до 11)");
                int month = scanner.nextInt();
                System.out.println("Введите номер дня (от 1 до 30)");
                int day = scanner.nextInt();
                System.out.println("Введите количество шагов");
                int currStep = scanner.nextInt();
                stepTracker.setCurrStep(month, day, currStep);
            } else if (command == 2) {
                System.out.println("Введите номер месяца (от 0 до 11)");
                stepTracker.getMonthStat(scanner.nextInt());
            } else if (command == 3) {
                    System.out.println("Введите новую цель по количеству шагов");
                    stepTracker.setTargetStep(scanner.nextInt());
            } else if (command == 4) {
                System.out.println("Выход из приложения");
                break;
            } else {
                System.out.println("Такой команды не существует");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Введите номер команды:");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения");
    }
}