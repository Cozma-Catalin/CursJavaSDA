public class Main {
    public static void main(String[] args) {
        Atm atm = Atm.getInstance();

        ClientFileReader clientFileReader = new ClientFileReader();
        clientFileReader.readClientAccount();

        try {
            atm.autentificateClient();
        } catch (WrongPinNumber e) {
            System.out.println(e.getMessage());
        }
        System.out.println(atm.getClient());
        System.out.println(atm.getMoney());
    }
}
