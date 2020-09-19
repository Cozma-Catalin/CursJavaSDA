public class VendingMachine {
    protected Cola cola;
    protected Fanta fanta;
    protected Watter watter;
    protected Cappucino cappucino;
    protected Americano americano;
    protected Esspresso esspresso;
    protected Chips chips;
    protected Croissant croissant;
    protected ProteinBar proteinBar;

    private VendingMachine() {

    }

    private static VendingMachine instance = new VendingMachine();

    public static VendingMachine getInstance() {
        return instance;
    }


    public Cola getCola() {
        return cola;
    }

    public Fanta getFanta() {
        return fanta;
    }

    public Watter getWatter() {
        return watter;
    }

    public Cappucino getCappucino() {
        return cappucino;
    }

    public Americano getAmericano() {
        return americano;
    }

    public Esspresso getEsspresso() {
        return esspresso;
    }

    public Chips getChips() {
        return chips;
    }

    public Croissant getCroissant() {
        return croissant;
    }

    public ProteinBar getProteinBar() {
        return proteinBar;
    }

    public void setCola(Cola cola) {
        this.cola = cola;
    }

    public void setFanta(Fanta fanta) {
        this.fanta = fanta;
    }

    public void setWatter(Watter watter) {
        this.watter = watter;
    }

    public void setCappucino(Cappucino cappucino) {
        this.cappucino = cappucino;
    }

    public void setAmericano(Americano americano) {
        this.americano = americano;
    }

    public void setEsspresso(Esspresso esspresso) {
        this.esspresso = esspresso;
    }

    public void setChips(Chips chips) {
        this.chips = chips;
    }

    public void setCroissant(Croissant croissant) {
        this.croissant = croissant;
    }

    public void setProteinBar(ProteinBar proteinBar) {
        this.proteinBar = proteinBar;
    }

    public void displayMeniu() {
        System.out.println("Meniu");
        System.out.println("1. Cola");
        System.out.println("2. Fanta");
        System.out.println("3. Watter");
        System.out.println("4. Esspresso");
        System.out.println("5. Americano");
        System.out.println("6. Cappucino");
        System.out.println("7. Croissant");
        System.out.println("8. Chips");
        System.out.println("9. Protein Bar");
        System.out.println("Choose your item.");
    }
}
