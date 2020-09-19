public class Main {
    public static void main(String[] args) {

        DrinkFileReader drinkFileReader = new DrinkFileReader();
        drinkFileReader.readDrinkFile();

        CoffeeFileReader coffeeFileReader = new CoffeeFileReader();
        coffeeFileReader.readCoffeeFile();

        SnackFileReader snackFileReader = new SnackFileReader();
        snackFileReader.readSnackFile();

        Client client = new Client();
        client.buy();

    }
}