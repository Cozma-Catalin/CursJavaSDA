public class Main {
    public static void main(String[] args) {
        Product fridge = new Fridge("Samsung","Ultra Frost",10,1800,"220",true);
        fridge.start();
        fridge.stop();



        Phone phone = new Phone("Samsung","S8",20,1200,"Ultra HD","1000 mAh","8 Gb");
        phone.start();
        phone.makePhoneCall();
        phone.takePictures();
        phone.connectToWifi();
        phone.stop();

        WashingMachine washingMachine = new WashingMachine();
        washingMachine.setBrand("Whirlpool");
        washingMachine.setModel("6th sense");
        washingMachine.setQuantity(5);
        washingMachine.setPrice(1600);
        washingMachine.start();
        washingMachine.selectWashingCycle("cotton");
        washingMachine.stop();
    }
}
