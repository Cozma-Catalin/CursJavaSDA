import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //sa se modeleze urm entitati: un student(nume,prenume,notamate,notainfo,notafizica,admis la politehnica boolean) mosteneste Person
        //interfata ptr note si admitere in fct de medii
        //sa se introduca de la tastatura numele, prenumele si notele studentilor
        //daca media notelor este mai mica decat 6 -->exceptie BadGradeException
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduceti numele studentului.");
        String firstName = scan.nextLine();
        System.out.println("Introduceti numele de famile a studentului.");
        String lastName = scan.nextLine();
        System.out.println("Introduceti nota la mate.");
        int mathGrade = scan.nextInt();
        System.out.println("Introduceti nota la info.");
        int infoGrade = scan.nextInt();
        System.out.println("Introduceti nota la fizica.");
        int phisGrade = scan.nextInt();
        System.out.println("Ati introdus datele:" + firstName + "," + lastName + ",nota mate:" + mathGrade + ",nota info:" + infoGrade + ",nota fizica:" + phisGrade + ".");
        Students marian = new Students("marian", "cozma", 8, 9, 7);
        Students catalin = new Students("catalin", "cozma", 8, 9, 4);
        Students adriana = new Students("adriana","rusu",4,3,7);

        try {
            marian.computeAverage();
        } catch (BadGradesException | PerfectGrades | OutOfRange e) {
            System.out.println("A fost o problema la calcularea mediei:" + e.getMessage());
        }
        System.out.println("Rezultatul admiterii este: " + marian.isAdmisPoli());

        //sa se creeze si sa se trateze exc cand notle sunt mai mari de 10 si mai mici de 1
        //interfata sa se calc media doar la mate si la fizica si sa se adauge un camp admis la fac de fiz si sa se calc med la mate si info +admis fac info
        //exc can d media este 10 perfect

        if (marian.getMedie() >= catalin.getMedie()) {
            System.out.println("Marian este mai bun decat cata.");
        } else {
            System.out.println("Cata este mai bun decat marian.");
        }

        int comparatie=marian.compareTo(catalin);
        if(comparatie<0){
            System.out.println("cata este mai bun decat marian.");
        }else if(comparatie==0){
            System.out.println("sunt egali.");
        } else{
            System.out.println("marian este mai bun.");
        }
        System.out.println(catalin);
        System.out.println(marian);
        System.out.println(adriana);
        System.out.println(catalin.equals(marian));

    }
}
