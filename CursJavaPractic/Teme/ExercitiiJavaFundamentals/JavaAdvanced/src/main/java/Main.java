public class Main {
    public static void main(String[] args) {
        Cerc cerc = new Cerc();
        System.out.println(cerc.draw());
        System.out.println(cerc.arie());
        System.out.println(cerc.perimetru());

        Dreptunghi dreptunghi = new Dreptunghi();
        System.out.println(dreptunghi.draw());
        System.out.println(dreptunghi.arie());
        System.out.println(dreptunghi.perimetru());

        Patrat patrat = new Patrat();
        System.out.println(patrat.draw());
        System.out.println(patrat.arie());
        System.out.println(patrat.perimetru());

        Shape cerc1 = new Cerc();
        System.out.println(cerc1.draw());


        Shape dreptunghi1 = new Dreptunghi();
        System.out.println(dreptunghi1.draw());


        Shape patrat1 = new Patrat();
        System.out.println(patrat1.draw());

        Calcule cerc2 = new Cerc();
        System.out.println(cerc2.arie());
        System.out.println(cerc2.perimetru());

        Calcule dreptunghi2 = new Dreptunghi();
        System.out.println(dreptunghi2.arie());
        System.out.println(dreptunghi2.perimetru());

        Calcule patrat2 = new Patrat();
        System.out.println(patrat2.arie());
        System.out.println(patrat2.perimetru());

        Animal porumbel = new Porumbel();
        System.out.println(porumbel.move());
        System.out.println(porumbel.doarme());

        Porumbel porumbel1 = new Porumbel();
        System.out.println(porumbel1.move());
        System.out.println(porumbel1.doarme());

        Ierbivore porumbel2 = new Porumbel();
        System.out.println(porumbel2.eat());


        Animal crocodil = new Crocodil();
        System.out.println(crocodil.move());
        System.out.println(crocodil.doarme());

        Crocodil crocodil1 = new Crocodil();
        System.out.println(crocodil1.move());
        System.out.println(crocodil1.doarme());
        crocodil1.eat();

        Carnivore crocodil2 = new Crocodil();
        System.out.println(crocodil2.eat());

        Animal soparla = new Soparla();
        System.out.println(soparla.move());
        System.out.println(soparla.doarme());

        Soparla soparla1 = new Soparla();
        System.out.println(soparla1.move());
        System.out.println(soparla1.doarme());
        soparla1.eat();

        Animal tigru = new Tigru();
        System.out.println(tigru.move());
        System.out.println(tigru.doarme());

        Tigru tigru1 = new Tigru();
        System.out.println(tigru1.move());
        System.out.println(tigru1.doarme());
        System.out.println(tigru1.pet());

        Salbatic tigru3 = new Tigru();
        System.out.println(tigru3.pet());



    }
}
