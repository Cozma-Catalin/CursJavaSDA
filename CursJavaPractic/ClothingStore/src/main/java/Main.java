

public class Main {

    public static void main(String[] args) {
        ClothingFileReader clothingFileReader = ClothingFileReader.getInstance();
        clothingFileReader.readClothingFile();
        clothingFileReader.displayTshirts();
        clothingFileReader.displayShirts();
        clothingFileReader.displayJackets();
        clothingFileReader.inverseSortTshirtSize();
        clothingFileReader.sortJacketByColor();
        clothingFileReader.sortShirtByPrice();
    }
}
