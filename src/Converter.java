public class Converter {
    public static double getDistance(int step){
        double result = step * 75.0 / 100 / 1000;
        return result;
    }

    public static double getKiloCalorie(int step){
        double result = step * 50.0 / 1000;
        return result;
    }
}
