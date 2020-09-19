public class Main {
    public static void main(String[] args) {
        int[] vector = {52, 65, 8, 48, 69, 102, 28, 46, 75, 16};
        int higestVectorValue = highestValue(vector);
        System.out.println(higestVectorValue);
    }

    public static int highestValue(int[] vector) {
        int max = 0;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] > max) {
                 max = vector[i];
            }
        }
        return max;
    }
}
