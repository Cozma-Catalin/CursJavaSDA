import java.util.Scanner;

public class FlowerShop {
    public static void main(String[] args) {

        Scanner usersInput = new Scanner(System.in);
        FlowerBouquetMaker flowerBouquetMaker = new FlowerBouquetMaker();

        System.out.println("Welcome to our flower shop.");
        System.out.println("We have this flowers:");
        System.out.println("1. Rose");
        System.out.println("2. Violet");
        System.out.println("3. Lily");
        System.out.println("4. Tulip");
        System.out.println("Do you wan't a flower or a bouquet ?");

        String answer = usersInput.nextLine();

        if (answer.equalsIgnoreCase("bouquet") || answer.equals("2")) {
            System.out.println("Which flowers you want your bouquet to be made with ?");
            int option = usersInput.nextInt();
            if (option == 1) {
                flowerBouquetMaker.makeRoseBouquet();
            } else if (option == 2) {
                flowerBouquetMaker.makeVioletBouquet();
            } else if (option == 3) {
                flowerBouquetMaker.makeLilyBouquet();
            } else if (option == 4) {
                flowerBouquetMaker.makeTulipBouquet();
            } else {
                System.out.println("We don't have this flowers.");
            }

        } else if (answer.equalsIgnoreCase("flower") || answer.equals("1")) {
            System.out.println("Which flower do you want ?");
            Scanner colorOption = new Scanner(System.in);
            int option = usersInput.nextInt();
            if (option == 1) {
                System.out.println("which rose color do you want ?");
                System.out.println("Red or white ?");
                String flowerColor = colorOption.nextLine();
                if (flowerColor.equalsIgnoreCase("Red") || flowerColor.equals("1")) {
                    Flower rose = new Rose();
                    System.out.println(rose.getPrice());
                    rose.getColor();
                } else if (flowerColor.equalsIgnoreCase("White") || flowerColor.equals("2")) {
                    Flower rose = new Rose();
                    FlowerDecorator whiteRose = new RoseDecorator(rose);
                    whiteRose.getColor();
                    System.out.println(whiteRose.getPrice());
                } else {
                    System.out.println("Wrong input.");
                }
            } else if (option == 2) {
                System.out.println("Which violet color do you want?");
                System.out.println("Purple or blue ?");
                String flowerColor = colorOption.nextLine();
                if (flowerColor.equalsIgnoreCase("Purple") || flowerColor.equals("1")) {
                    Flower violet = new Violet();
                    VioletDecorator purpleViolet = new VioletDecorator(violet);
                    purpleViolet.getColor();
                    System.out.println(purpleViolet.getPrice());
                } else if (flowerColor.equalsIgnoreCase("Blue") || flowerColor.equals("2")) {
                    Flower violet = new Violet();
                    System.out.println(violet.getPrice());
                    violet.getColor();
                } else {
                    System.out.println("We don't have this flower.");
                }
            } else if (option == 3) {
                System.out.println("Which lily color you want ?");
                System.out.println("White or purple ?");
                String flowerColor = colorOption.nextLine();
                if (flowerColor.equalsIgnoreCase("White") || flowerColor.equals("1")) {
                    Flower lily = new Lily();
                    System.out.println(lily.getPrice());
                    lily.getColor();
                } else if (flowerColor.equalsIgnoreCase("Purple") || flowerColor.equals("2")) {
                    Flower lily = new Lily();
                    LilyDecorator purpleLily = new LilyDecorator(lily);
                    purpleLily.getColor();
                    System.out.println(purpleLily.getPrice());
                } else {
                    System.out.println("We don't have this flower.");
                }

            } else if (option == 4) {
                System.out.println("Yellow or white ?");
                String flowerColor = colorOption.nextLine();
                if (flowerColor.equalsIgnoreCase("Yellow") || flowerColor.equals("1")) {
                    Flower tulip = new Tulip();
                    System.out.println(tulip.getPrice());
                    tulip.getColor();
                } else if (flowerColor.equalsIgnoreCase("White") || flowerColor.equals("2")) {
                    Flower tulip = new Tulip();
                    TulipDecorator whiteTulip = new TulipDecorator(tulip);
                    whiteTulip.getColor();
                    System.out.println(whiteTulip.getPrice());
                } else {
                    System.out.println("We don't have this flower.");
                }

            } else {
                System.out.println("We don't have this flower.");
            }

        } else {
            System.out.println("Wrong input.");
        }
        System.out.println("Thank you ! Come again !");
    }

}