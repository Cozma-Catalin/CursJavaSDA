import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ClothingFileReader {

    private ClothingFileReader(){}

    private static ClothingFileReader instance = new ClothingFileReader();
    public static ClothingFileReader getInstance(){return instance;}

    List<Shirt> shirtList = new ArrayList<>();
    List<Tshirt> tshirtList = new ArrayList<>();
    List<Jacket> jacketList = new ArrayList<>();

    ProductFactory productFactory = new ProductFactory();

    public void readClothingFile() {
        String filePath = "C:\\Users\\Catalin\\Desktop\\ClothingStore.txt";
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            readFile(bufferedReader);

        } catch (
                IOException e) {
            System.out.println("A aparut o eroare: " + e.getMessage());
        }
    }

    private void readFile(BufferedReader bufferedReader) throws IOException {
        String text = bufferedReader.readLine();
        while (text != null) {
            String[] array = text.split(" ");
            createClothingType(array);
            text = bufferedReader.readLine();
        }
    }

    private void createClothingType(String[] array) {
        if (array[0].equalsIgnoreCase("Tshirt")) {
           Tshirt tshirt = (Tshirt) productFactory.getProduct("Tshirt");
           tshirt.setType(array[0]);
           tshirt.setBrand(array[1]);
           tshirt.setColor(array[2]);
           tshirt.setSize(array[3]);
           tshirt.setPrice(Integer.valueOf(array[4]));
           tshirtList.add(tshirt);
        } else if (array[0].equalsIgnoreCase("Shirt")) {
            Shirt shirt =(Shirt) productFactory.getProduct("Shirt");
            shirt.setType(array[0]);
            shirt.setBrand(array[1]);
            shirt.setColor(array[2]);
            shirt.setSize(array[3]);
            shirt.setPrice(Integer.valueOf(array[4]));
            shirtList.add(shirt);
        } else {
            Jacket jacket = (Jacket) productFactory.getProduct("Jacket");
            jacket.setType(array[0]);
            jacket.setBrand(array[1]);
            jacket.setColor(array[2]);
            jacket.setSize(array[3]);
            jacket.setPrice(Integer.valueOf(array[4]));
            jacketList.add(jacket);
        }
    }

    public void displayTshirts(){
        System.out.println("Tshirt list: ");
        for(Tshirt tshirt : tshirtList){
            System.out.println(tshirt);
        }
    }

    public void displayShirts(){
        System.out.println("Shirt list: ");
        for(Shirt shirt : shirtList){
            System.out.println(shirt);
        }
    }

    public void displayJackets(){
        System.out.println("Jacket list: ");
        for(Jacket jacket : jacketList){
            System.out.println(jacket);
        }

    }

    public void inverseSortTshirtSize() {
        Map<Integer, Tshirt> tshirtMap = new HashMap<>();
        for (Tshirt tshirt : tshirtList) {
            if (tshirt.getSize().equalsIgnoreCase("xl")) {
                tshirtMap.put(0, tshirt);
            } else if (tshirt.getSize().equalsIgnoreCase("m")) {
                tshirtMap.put(1, tshirt);
            } else {
                tshirtMap.put(2, tshirt);
            }
        }
        System.out.println(tshirtMap);
    }

    public void sortShirtByPrice() {
        TshirtComparator shirtComparator = new TshirtComparator();
        Collections.sort(tshirtList,shirtComparator);
        for(Tshirt tshirt : tshirtList ){
            System.out.println(tshirt);
        }
    }


    public void sortJacketByColor() {
        Map<String, ArrayList<Jacket>> jacketMap = new HashMap<>();
        jacketMap.put("black", new ArrayList<>());
        jacketMap.put("blue", new ArrayList<>());
        jacketMap.put("green", new ArrayList<>());

        for (Jacket jacket : jacketList) {
            if (jacket.getColor().equalsIgnoreCase("black")) {
                jacketMap.get("black").add(jacket);
            } else if (jacket.getColor().equalsIgnoreCase("blue")) {
                jacketMap.get("blue").add(jacket);
            } else {
                jacketMap.get("green").add(jacket);
            }
        }

        ArrayList<Jacket> blackJackets = jacketMap.get("black");
        System.out.println("Black jackets:");
        for (Jacket jacket : blackJackets) {
            System.out.println(jacket);
        }

        ArrayList<Jacket> blueJackets = jacketMap.get("blue");
        System.out.println("Blue jackets: ");
        for (Jacket jacket : blueJackets) {
            System.out.println(jacket);
        }

        ArrayList<Jacket> greenJacket = jacketMap.get("green");
        System.out.println("Green jackets: ");
        for (Jacket jacket : greenJacket) {
            System.out.println(jacket);
        }
    }

}
