import java.util.PrimitiveIterator;

public class Store {
    private LapTop laptop;
    private Pc pc;
    private Monitor monitor;
    private Keyboard keyboard;
    private Mouse mouse;
    private HardDisk hardDisk;
    private VideoCard videoCard;
    private MemoryCard memoryCard;
    private WebCam webCam;
    private Processor processor;

    private Store(){}

    private static Store instance = new Store();

    public static Store getInstance(){
        return instance;
    }

    public LapTop getLaptop() {
        return laptop;
    }

    public void setLaptop(LapTop laptop) {
        this.laptop = laptop;
    }

    public Pc getPc() {
        return pc;
    }

    public void setPc(Pc pc) {
        this.pc = pc;
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

    public HardDisk getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(HardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    public VideoCard getVideoCard() {
        return videoCard;
    }

    public void setVideoCard(VideoCard videoCard) {
        this.videoCard = videoCard;
    }

    public MemoryCard getMemoryCard() {
        return memoryCard;
    }

    public void setMemoryCard(MemoryCard memoryCard) {
        this.memoryCard = memoryCard;
    }

    public WebCam getWebCam() {
        return webCam;
    }

    public void setWebCam(WebCam webCam) {
        this.webCam = webCam;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

}
