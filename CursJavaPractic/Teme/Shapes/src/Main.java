public class Main {
    public static void main(String[] args) {
        Circle A = new Circle(1, 3);
        Triangle B = new Triangle(3, 4, 2, 8, 7);
        Patrulater C = new Patrulater(4, 8, 3, 6, 2);
        System.out.println( A.draw());
        System.out.println( B.draw());
        System.out.println(C.draw());
        System.out.println("Perimetrul triunghiului este : " + B.perimetru());
        System.out.println("Aria triunghiului este : " + B.arie());
        System.out.println("Aria cercului este : " + A.arie());
        System.out.println("Perimetrul cercului este : " + A.perimetru());
        System.out.println("Perimetrul patratului este " + C.perimetru());
        System.out.println("Aria patratului este : " + C.arie());
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        TriunghiEchilateral D = new TriunghiEchilateral(3, 5);
        Patrat E = new Patrat(4, 3);
        System.out.println( D.draw());
        System.out.println("Perimetrul acestui triunghi este : " + D.perimetru());
        System.out.println( E.draw());
        System.out.println("Perimetrul acestrui patrat este : " + E.perimetru());
    }
}
