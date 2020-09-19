public class PizzaMaker {


    public void makePizzaDiavola(){
        Pizza diavola = new Diavola();
        diavola.cook();
    }

    public void makePizzaVegan(){
        Pizza vegan = new Vegan();
        vegan.cook();
    }

    public void makePizzaQuatroStagioni(){
        Pizza quatroStagioni = new QuatroStagioni();
        quatroStagioni.cook();
    }

    public void makePizzaPepperoni(){
        Pizza pepperoni = new Pepperoni();
        pepperoni.cook();
    }




}
