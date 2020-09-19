import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ClientFileReader {
    public ClientFileReader() {
    }

    Atm atm = Atm.getInstance();

    public void readClientAccount() {
        try {
            String clientAccountPath = "C:\\Users\\Catalin\\Desktop\\ClientAccount.txt";
            FileReader clientFileReader = new FileReader(clientAccountPath);
            BufferedReader clientBufferedReader = new BufferedReader(clientFileReader);
            String clientInfo = clientBufferedReader.readLine();
            while (clientInfo != null && !clientInfo.isEmpty()) {
                String[] arrayClient = clientInfo.split(",");
                Client client = new Client(arrayClient[0], arrayClient[1],Integer.valueOf(arrayClient[2]), Double.valueOf(arrayClient[3]));
                atm.setClient(client);
                clientInfo = clientBufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
