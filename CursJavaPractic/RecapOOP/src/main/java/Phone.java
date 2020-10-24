public class SmartPhone extends Product {
    private String display;
    private String batterySize;
    private String cam;

    public SmartPhone(String brand, String model, double quantity, double price, String display, String batterySize,String cam) {
        super(brand, model, quantity, price);
        this.display = display;
        this.batterySize = batterySize;
        this.cam = cam;
    }

    public SmartPhone() {}

    public void start() {
        System.out.println("Phone started...setup account.");
    }

    public void stop() {
        System.out.println("Phone shutting down.");
    }

    public void takingPictures(){
        System.out.println("Click...:)) picture taken.");
    }

    public void makePhoneCall(){
        System.out.println("Calling ...");
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getBatterySize() {
        return batterySize;
    }

    public void setBatterySize(String batterySize) {
        this.batterySize = batterySize;
    }

    public String getCam() {
        return cam;
    }

    public void setCam(String cam) {
        this.cam = cam;
    }
}
