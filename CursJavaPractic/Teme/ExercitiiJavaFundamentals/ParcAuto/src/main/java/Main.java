import java.io.*;

public class Main {
    public static void main(String[] args) {
        //sa se modeleze un parc auto
        //masinile vor fi citite dintr un fisier
        //in fisier o sa avem marca model,culoare,pret,combustibil,data fabricarii
        //3 tipuri de maini
        //nemtesti
        //frantuzesti
        //altele

        //o sa citiim din fisier masinile
        //daca masina este nemteasca le scriem intr un fisier separat
        //la fel si ptr celellatlte
        //masinile au comportament
        //pot fi vandute in leasing + avans care se scade din pretul total
        //putem lua nr de rate si cat valoreaza
        //masinile pot fi comparate
        //calitatea este data de anul de fabricatie
        //masinile au ca atribut si vandut(cele vandute vor fi scrise intr un alt fisier)
        //afisam toate masinile vandute
        //masinile vandute o sa fie cele nemtesti care au culoarea neagra si combustibilul benzina


        //avem nevoie de o clasa masina(marca,model,culoare,pret,combustibil,datafabricare)-->atribut vandut
        //interfata leasing(getrate+getvaloare)
        //implement comparable<masina>
        //fisier cu masini si sortarea lor in fisiere separate cu masini
        //fisier nou cu masinile vandute
        //citim si afisam fisierul cu masini vandute


        try {
            String masini = "C:\\Users\\Catalin\\Desktop\\Masini\\Masini.txt";
            FileReader masiniReader = new FileReader(masini);
            BufferedReader masiniBuffer = new BufferedReader(masiniReader);


            String masiniNemtesti = "C:\\Users\\Catalin\\Desktop\\Masini\\MasiniNemtesti.txt";
            FileWriter masiniNemtestiWriter = new FileWriter(masiniNemtesti);
            BufferedWriter masiniNemtestiBuffer = new BufferedWriter(masiniNemtestiWriter);

            String masiniFrantuzesti = "C:\\Users\\Catalin\\Desktop\\Masini\\MasiniFrantuzesti.txt";
            FileWriter masiniFrantuzestiWriter = new FileWriter(masiniFrantuzesti);
            BufferedWriter masiniFrantuzestiBuffer = new BufferedWriter(masiniFrantuzestiWriter);

            String alteMasini = "C:\\Users\\Catalin\\Desktop\\Masini\\AlteMasini.txt";
            FileWriter alteMasiniWriter = new FileWriter(alteMasini);
            BufferedWriter alteMasiniBuffer = new BufferedWriter(alteMasiniWriter);

            String masiniVandute = "C:\\Users\\Catalin\\Desktop\\Masini\\MasiniVandute.txt";
            FileWriter masiniVanduteWriter = new FileWriter(masiniVandute);
            BufferedWriter masiniVanduteBuffer = new BufferedWriter(masiniVanduteWriter);

            String text = masiniBuffer.readLine();
            String text2 = masiniBuffer.readLine();
            while (text != null && text2 != null) {
                String[] array = text.split(",");
                Masina masina = new Masina(array[0], array[1], array[2], Integer.valueOf(array[3]), array[4], Integer.valueOf(array[5]));
                System.out.println("Rata la masina:" + masina.getMarca() + " este: " + masina.pretRata() + ".");

                String[] array2 = text2.split(",");
                Masina masina2 = new Masina(array2[0], array2[1], array2[2], Integer.valueOf(array2[3]), array2[4], Integer.valueOf(array2[5]));

                System.out.println(masina.compareTo(masina2));

                if (masina.getMarca().equals("Renault") || masina.getMarca().equals("Ford")) {
                    masiniFrantuzestiBuffer.write(text);
                    masiniFrantuzestiBuffer.newLine();
                } else if (masina.getMarca().equals("BMW") || masina.getMarca().equals("Audi")) {
                    masiniNemtestiBuffer.write(text);
                    masiniNemtestiBuffer.newLine();
                } else {
                    alteMasiniBuffer.write(text);
                    alteMasiniBuffer.newLine();
                }

                if (masina.isVandut() == true) {
                    masiniVanduteBuffer.write(text);
                    masiniVanduteBuffer.newLine();

                }

                text = masiniBuffer.readLine();

            }
            masiniVanduteBuffer.flush();
            masiniVanduteBuffer.close();

            masiniFrantuzestiBuffer.flush();
            masiniFrantuzestiBuffer.close();

            masiniNemtestiBuffer.flush();
            masiniNemtestiBuffer.close();

            alteMasiniBuffer.flush();
            alteMasiniBuffer.close();

        } catch (IOException e) {
            System.out.println("Am intampinat o exceptie: " + e.getMessage());
        }
    }
}
