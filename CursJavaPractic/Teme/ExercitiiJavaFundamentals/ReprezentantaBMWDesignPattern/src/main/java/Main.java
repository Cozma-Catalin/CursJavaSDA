public class Main {
    public static void main(String[] args) {
      // Pentru a implementa designul prototype trebuie sa suprascriem metoda clone din clasa Object
      //Prototype ne ajuta sa creem obiecte care nu difera foarte mult intre ele putand sa le customizam dupa nevoi

        Car BMW = new Car("BMW","X4","2000","Blue");
        Car BMW2 = BMW.clone();
        BMW2.setColor("Green");
        System.out.println(BMW2);
        System.out.println(BMW);

        Car Audi = new Car("Audi","A4","2000","White");
        Car Audi2 = Audi.clone();
        Audi2.setEngine("3000");
        System.out.println(Audi);
        System.out.println(Audi2);

    }
}
