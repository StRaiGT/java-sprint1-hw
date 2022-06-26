public class StepTracker {
    int targetStep = 10000;
    MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void setCurrStep(int month, int day, int currStep){
        monthToData[month].dayData[day - 1] = currStep;
        System.out.println("За " + day + " день " + month + " месяца пройдено "
                +  monthToData[month].dayData[day - 1] + " шагов\n");
    }

    public void setTargetStep(int step){
        targetStep = step;
        System.out.println("Теперь новая цель - " + targetStep + " шагов в день\n");
    }

    public String getStepPerDay(int month){
        String result = "";
        for (int i = 0; i < monthToData[month].dayData.length; i++) {
            int currStep = monthToData[month].dayData[i];
            result += (i + 1) + " день: " + currStep;
            if (i != monthToData[month].dayData.length - 1) {
                result += ", ";
            }
        }
        return result;
    }

    public int getTotalStep(int month) {
        int totalMonthStep = 0;
        for (int i = 0; i < monthToData[month].dayData.length; i++) {
            totalMonthStep += monthToData[month].dayData[i];
        }
        return totalMonthStep;
    }

    public int getMaxStep(int month) {
        int maxMonthStep = 0;
        for (int i = 0; i < monthToData[month].dayData.length; i++) {
            int currStep = monthToData[month].dayData[i];
            if (currStep > maxMonthStep) {
                maxMonthStep = currStep;
            }
        }
        return maxMonthStep;
    }

    public double getAverageStep(int month) {
        return (double) getTotalStep(month) / monthToData[month].dayData.length;
    }

    public int getMaxSeries(int month){
        int maxTargetStepSeries = 0;
        int TargetStepSeries = 0;
        for (int i = 0; i < monthToData[month].dayData.length; i++) {
            int currStep = monthToData[month].dayData[i];
            if (currStep >= targetStep){
                TargetStepSeries++;
            } else {
                TargetStepSeries = 0;
            }
            if (TargetStepSeries > maxTargetStepSeries) {
                    maxTargetStepSeries = TargetStepSeries;
            }
        }
        return maxTargetStepSeries;
    }
}
