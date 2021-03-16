import javax.swing.*;

public class Variabile {
    public static void main(String[] args) {
        int x = 6;
        int y = 8;
        double z = 10;
        double m = x + y * z;
        if (x > y) {
            int sum = x + y;

            System.out.println(sum);

            System.out.println(x);
            } else {
             int i = x * y;
            System.out.println(x);
            System.out.println(i);

        }
        for(int c = 2; c < 20; c++) {
            double fractie = z / c;
            System.out.println(fractie);
        }
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        System.out.println(m);

        JFrame Math = new JFrame();
        Math.setVisible(true);
        Math.setTitle("Exercitii");
        Math.setSize(800,600);

        JLabel label = new JLabel();
        label.setText("calcule");
        Math.add(label);


    }

}