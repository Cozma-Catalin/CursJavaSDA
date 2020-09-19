public class Main {
    public static void main(String[] args) {
        String[] cuvinte = {"unelte", "ocupatie", "organizare", "oameni", "creatie", "artistice", "coduri"};
        concatenare(cuvinte);
    }

    //se da un array de 7 cuv: sa se + cuv de pe poz divizibile cu 3 si >0
    public static void concatenare(String[] cuvinte) {
        String cuvNoi = " ";
        for (int i = 1; i < cuvinte.length; i++) {
            if (i % 3 == 0) {
                cuvNoi += cuvinte[i]+" ";
            }
        }
        System.out.println(cuvNoi);
    }
}
