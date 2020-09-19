import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        Meniu meniu = Meniu.getInstance();
        System.out.println(meniu.getBauturi());
        Meniu meniu2 = Meniu.getInstance();
        System.out.println(meniu2.getBauturi());

        meniu2.setBauturi("cico,vin,rachiu");
       //schimbarile sunt valabile pentru toate instantele(meniu)
        System.out.println(meniu2.getBauturi());
        System.out.println(meniu.getBauturi());

        //Inceput de clasa a 9 a
        Clasa clasa = Clasa.getInstance();
        Catalog catalog = Catalog.getInstance();

        clasa.setClasa("Clasa a 9 a B");
        catalog.setName("Catalogul clasei a 9 a B");

        Clasa clasa2 = Clasa.getInstance();
        Catalog catalog2 = Catalog.getInstance();

        System.out.println(clasa.getClasa());
        System.out.println(catalog.getName());

        System.out.println(clasa2.getClasa());
        System.out.println(catalog2.getName());

        clasa.setClasa("Clasa a 10 a B");
        catalog.setName("Catalogul clasei a 10 a B");

        System.out.println(clasa.getClasa());
        System.out.println(catalog.getName());

        System.out.println(clasa2.getClasa());
        System.out.println(catalog2.getName());

    }
}
