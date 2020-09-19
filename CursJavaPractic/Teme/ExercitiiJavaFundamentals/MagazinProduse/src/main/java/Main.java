import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //sa se citeasca dintr un fisier produsele aflate la vanzare dintrt un magazin
        //pe fiecare rand vom avea categoria(alimentare,curatenie,auto),numele,raionul,pret,discount
        //sa se grupeze produsele in colectii in fct de categorie,pretul  <100 ron,<50Ron si >100RON
        //colectie ptr categorii, ptr pret si ptr reducere--> reducere<10%....reducere>25%....reducere>30
        //sa se scrie produsele in fct de colectia din care fac parte in fisiere separate

        try {
            String filepath = "C:\\Users\\Catalin\\Desktop\\Magazin.txt";
            FileReader fileReader = new FileReader(filepath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String text = bufferedReader.readLine();


            String filepathAlimentare = "C:\\Users\\Catalin\\Desktop\\ProduseAlimentare.txt";
            FileWriter fileWriterAlimente = new FileWriter(filepathAlimentare);
            BufferedWriter bufferedWriterAlimentare = new BufferedWriter(fileWriterAlimente);

            String filepathCuratenie = "C:\\Users\\Catalin\\Desktop\\ProduseCuratenie.txt";
            FileWriter fileWriterCuratenie = new FileWriter(filepathCuratenie);
            BufferedWriter bufferedWriterCuratenie = new BufferedWriter(fileWriterCuratenie);

            String filepathAuto = "C:\\Users\\Catalin\\Desktop\\ProduseAuto.txt";
            FileWriter fileWriterAuto = new FileWriter(filepathAuto);
            BufferedWriter bufferedWriterAuto = new BufferedWriter(fileWriterAuto);

            Map<String, ArrayList<Product>> categoryProdMap = new HashMap<>();
            Map<String, ArrayList<Product>> priceProdMap = new HashMap<>();
            Map<String, ArrayList<Product>> discountProdMap = new HashMap<>();

            categoryProdMap.put("Alimentare", new ArrayList<>());
            categoryProdMap.put("Curatenie", new ArrayList<>());
            categoryProdMap.put("Auto", new ArrayList<>());

            priceProdMap.put("Lower50", new ArrayList<>());
            priceProdMap.put("Lower100", new ArrayList<>());
            priceProdMap.put("Higher100", new ArrayList<>());

            discountProdMap.put("Less10", new ArrayList<>());
            discountProdMap.put("Higher20", new ArrayList<>());
            discountProdMap.put("Higher30", new ArrayList<>());


            while (text != null) {
                String[] array = text.split(";");
                Product produs = new Product(array[0], array[1], array[2], array[3], array[4]);
                if (produs.getCategory().equals("Alimentare")) {
                    categoryProdMap.get("Alimentare").add(produs);
                    bufferedWriterAlimentare.write(text);
                    bufferedWriterAlimentare.newLine();
                } else if (produs.getCategory().equals("Curatenie")) {
                    categoryProdMap.get("Curatenie").add(produs);
                    bufferedWriterCuratenie.write(text);
                    bufferedWriterCuratenie.newLine();
                } else {
                    categoryProdMap.get("Auto").add(produs);
                    bufferedWriterAuto.write(text);
                    bufferedWriterAuto.newLine();
                }

                if (Integer.valueOf(produs.getPrice()) < 50) {
                    priceProdMap.get("Lower50").add(produs);
                } else if (Integer.valueOf(produs.getPrice()) < 100) {
                    priceProdMap.get("Lower100").add(produs);
                } else {
                    priceProdMap.get("Higher100").add(produs);
                }

                if (Integer.valueOf(produs.getDiscount()) < 10) {
                    discountProdMap.get("Less10").add(produs);
                } else if (Integer.valueOf(produs.getDiscount()) > 20) {
                    discountProdMap.get("Higher20").add(produs);
                } else {
                    discountProdMap.get("Higher30").add(produs);
                }

                bufferedWriterAlimentare.flush();
                bufferedWriterCuratenie.flush();
                bufferedWriterAuto.flush();

                text = bufferedReader.readLine();
            }
            bufferedWriterAlimentare.close();
            bufferedWriterCuratenie.close();
            bufferedWriterAuto.close();

            ArrayList<Product> prodAlimentareList = categoryProdMap.get("Alimentare");
            for (Product produs : prodAlimentareList) {
                System.out.println(produs.toString());
            }

            ArrayList<Product> prodCuratenieList = categoryProdMap.get("Curatenie");
            for (Product produs : prodCuratenieList) {
                System.out.println(produs.toString());
            }

            ArrayList<Product> prodAutoList = categoryProdMap.get("Auto");
            for (Product produs : prodAutoList) {
                System.out.println(produs.toString());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
