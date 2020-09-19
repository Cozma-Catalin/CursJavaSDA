import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Store {
    protected PC pc;
    protected Map<String,LapTop> lapTop;
    protected Monitor monitor;
    protected Keyboard keyboard;
    protected Mouse mouse;
    protected Processor processor;
    protected MemoryCard memoryCard;
    protected VideoCard videoCard;
    protected WebCam webCam;
    protected HardDisk hardDisk;

    private Store(){

    }

    private static Store instance = new Store();

    public static Store getInstance(){
        return instance;
    }

    public PC getPc() {
        return pc;
    }

    public void setPc(PC pc) {
        this.pc = pc;
    }

    public Map<String,LapTop> getLapTop() {
        return lapTop;
    }

    public void setLapTop(Map<String,LapTop> lapTop) {
        this.lapTop = lapTop;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public MemoryCard getMemoryCard() {
        return memoryCard;
    }

    public void setMemoryCard(MemoryCard memoryCard) {
        this.memoryCard = memoryCard;
    }

    public VideoCard getVideoCard() {
        return videoCard;
    }

    public void setVideoCard(VideoCard videoCard) {
        this.videoCard = videoCard;
    }

    public WebCam getWebCam() {
        return webCam;
    }

    public void setWebCam(WebCam webCam) {
        this.webCam = webCam;
    }

    public HardDisk getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(HardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    public void displayMeniu(){
        System.out.println("Welcome to our store.Here's our Meniu:");
        System.out.println("1. LapTop");
        System.out.println("2. Pc");
        System.out.println("3.Components");
        System.out.println("4. Perifericals");
        System.out.println("What would you like to buy ?");

    }


}
