public class CarMaker {
    public Car makeBMW() {
        Car bmw = new BMW("BMW");
        bmw.build();
        return bmw;
    }

    public Car makeDacia() {
        Car dacia = new Dacia("Dacia");
        dacia.build();
        return dacia;
    }

    public Car makeTrabant() {
        Car trabant = new Trabant("Trabant");
        trabant.build();
        return trabant;
    }
}
