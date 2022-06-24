import java.util.Arrays;

public class StepTracker {
    class MonthData {
        int[] dayData = new int[30]; // Массив заполняется нулевыми значениями
    }

    int targetStep = 10000;
    MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void setCurrStep(int month, int day, int currStep){
        if (currStep >= 0) {
            monthToData[month].dayData[day - 1] = currStep;
            System.out.println("За " + day + " день " + month + " месяца пройдено "
                    +  monthToData[month].dayData[day - 1] + " шагов\n");
        } else {
            System.out.println("Изменения не внесены. Количество шагов должно быть неотрицательным!\n");
        }
    }

    public void setTargetStep(int step){
        if (step >= 0) {
            targetStep = step;
            System.out.println("Теперь новая цель - " + targetStep + " шагов в день\n");
        } else {
            System.out.println("Изменения не внесены. Количество шагов должно быть неотрицательным!\n");
        }
    }

    public void getMonthStat(int month){
        int totalMonthStep = 0;
        int maxMonthStep = 0;
        int maxTargetStepSeries = 0;
        int TargetStepSeries = 0;

        for (int i = 0; i < monthToData[month].dayData.length; i++) {
            int currStep = monthToData[month].dayData[i];
            System.out.print((i + 1) + " день: " + currStep);
            if (i != monthToData[month].dayData.length - 1){
                System.out.print(", ");
            } else {
                System.out.println();
            }

            totalMonthStep += currStep;

            if (currStep > maxMonthStep) {
                maxMonthStep = currStep;
            }

            if (currStep >= targetStep){
                TargetStepSeries++;
            } else {
                if (TargetStepSeries > maxTargetStepSeries) {
                    maxTargetStepSeries = TargetStepSeries;
                }
                TargetStepSeries = 0;
            }
        }
        double averageMonthStep = (double) totalMonthStep / monthToData[month].dayData.length;

        System.out.println("Общее количество шагов за месяц - " + totalMonthStep);
        System.out.println("Максимальное пройденное количество шагов в месяце - " + maxMonthStep);
        System.out.println("Среднее количество шагов - " + averageMonthStep);
        System.out.println("Пройденная дистанция (в км) - " + Converter.getDistance(totalMonthStep));
        System.out.println("Количество сожжённых килокалорий - " + Converter.getKiloCalorie(totalMonthStep));
        System.out.println("Лучшая серия - " + maxTargetStepSeries + "\n");
    }
}
