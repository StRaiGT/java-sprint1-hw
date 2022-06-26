public class Converter {
    final static double STEP_TO_KM = 75.0 / 100 / 1000;
    final static double STEP_TO_KILOCALORIE = 50.0 / 1000;

    public static double getDistance(int step){
        return step * STEP_TO_KM;
    }

    public static double getKiloCalorie(int step){
        return step * STEP_TO_KILOCALORIE;
    }
}
