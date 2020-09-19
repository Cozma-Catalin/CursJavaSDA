import java.io.*;
import java.util.*;

public class Main {

    public static int countPacientiRadiologie = 0;
    public static int countPacientiChirurgie = 0;
    public static int countPacientiOrtopedie = 0;

    public static void main(String[] args) {
        //sa se modeleze un spital
        //dintr un fisier se vor citi de pe fiecare rand numele,prenumele,specializare,tura sau nu(medic)
        //sa se separe medicii in 2 colectii:1 - functie de specializare, 2:-de tura sau nu
        //fiecare categorie din fiecare colectie sa fie scrisa intr un fisier separat
        //daca exista vreo categorie in fct de specializare care nu este de tura sa se arunce o exceptie NobodyOnShiftException
        // dintr un alt fisierse vor citi de pe fiecare rand numele, prenumele, varsta ,specializare ptr care a venit un pacient
        //sa se separe pacientii in fct de specializare
        //daca sunt mai multi de 5 la o specializare -->Exceptie TooCrowdedException
        try {
            String filePathHospital = "C:\\Users\\Catalin\\Desktop\\Hospital\\Hospital.txt";
            FileReader fileReaderHospital = new FileReader(filePathHospital);
            BufferedReader bufferedReaderHospital = new BufferedReader(fileReaderHospital);
            String text = bufferedReaderHospital.readLine();

            String filePathMedici = "C:\\Users\\Catalin\\Desktop\\Hospital\\Medici.txt";
            FileWriter fileWriterMedici = new FileWriter(filePathMedici);
            BufferedWriter bufferedWriterMedici = new BufferedWriter(fileWriterMedici);

            String filePathPacientiChirurgie = "C:\\Users\\Catalin\\Desktop\\Hospital\\PacientiChirurgie.txt";
            FileWriter fileWriterPacientiChirurgie = new FileWriter(filePathPacientiChirurgie);
            BufferedWriter bufferedWriterPacientiChirurgie = new BufferedWriter(fileWriterPacientiChirurgie);

            String filePathPacientiRadiologie = "C:\\Users\\Catalin\\Desktop\\Hospital\\PacientiRadiologie.txt";
            FileWriter fileWriterPacientiRadiologie = new FileWriter(filePathPacientiRadiologie);
            BufferedWriter bufferedWriterPacientiRadiologie = new BufferedWriter(fileWriterPacientiRadiologie);

            String filePathPacientiOrtopedie = "C:\\Users\\Catalin\\Desktop\\Hospital\\PacientiOrtopedie.txt";
            FileWriter fileWriterPacientiOrtopedie = new FileWriter(filePathPacientiOrtopedie);
            BufferedWriter bufferedWriterPacientiOrtopedie = new BufferedWriter(fileWriterPacientiOrtopedie);

            String filePathChirurgie = "C:\\Users\\Catalin\\Desktop\\Hospital\\Chirurgie.txt";
            FileWriter fileWriterChirurgie = new FileWriter(filePathChirurgie);
            BufferedWriter bufferedWriterChirurgie = new BufferedWriter(fileWriterChirurgie);

            String filePathRadiologie = "C:\\Users\\Catalin\\Desktop\\Hospital\\Radiologie.txt";
            FileWriter fileWriterRadiologie = new FileWriter(filePathRadiologie);
            BufferedWriter bufferedWriterRadiologie = new BufferedWriter(fileWriterRadiologie);

            String filePathOrtopedie = "C:\\Users\\Catalin\\Desktop\\Hospital\\Ortopedie.txt";
            FileWriter fileWriterOrtopedie = new FileWriter(filePathOrtopedie);
            BufferedWriter bufferedWriterOrtopedie = new BufferedWriter(fileWriterOrtopedie);

            String filePathOnDuty = "C:\\Users\\Catalin\\Desktop\\Hospital\\OnDuty.txt";
            FileWriter fileWriterOnDuty = new FileWriter(filePathOnDuty);
            BufferedWriter bufferedWriterOnDuty = new BufferedWriter(fileWriterOnDuty);

            String filePathNotOnDuty = "C:\\Users\\Catalin\\Desktop\\Hospital\\NotOnDuty.txt";
            FileWriter fileWriterNotOnDuty = new FileWriter(filePathNotOnDuty);
            BufferedWriter bufferedWriterNotOnDuty = new BufferedWriter(fileWriterNotOnDuty);


            Map<String, List<Medic>> shift = new HashMap<>();
            shift.put("onDuty", new LinkedList<>());
            shift.put("offDuty", new LinkedList<>());
            List<Medic> onDuty = new LinkedList<>();
            List<Medic> offDuty = new LinkedList<>();


            Map<String, ArrayList<Medic>> specializare = new HashMap<>();
            specializare.put("Chirurg", new ArrayList<>());
            specializare.put("Radiolog", new ArrayList<>());
            specializare.put("Ortoped", new ArrayList<>());

            Map<String, LinkedList<Pacient>> specializareCautata = new HashMap<>();
            specializareCautata.put("Chirurgie", new LinkedList<>());
            specializareCautata.put("Radiologie", new LinkedList<>());
            specializareCautata.put("Ortopedie", new LinkedList<>());

            List<Pacient> pacientiChirurgie = new LinkedList<>();
            List<Pacient> pacientiRadiologie = new LinkedList<>();
            List<Pacient> pacientiOrtopedie = new LinkedList<>();


            while (text != null) {
                String[] array = text.split(",");
                if (array[3].equals("TRUE") || array[3].equals("FALSE")) {
                    bufferedWriterMedici.write(text);
                    bufferedWriterMedici.newLine();
                    bufferedWriterMedici.flush();
                    Medic medic = new Medic(array[0], array[1], array[2], Boolean.valueOf(array[3]));

                    if (medic.specializare.equals("CHIRURGIE")) {
                        specializare.get("Chirurg").add(medic);
                        medic.goingToHospital();
                        bufferedWriterChirurgie.write(text);
                        bufferedWriterChirurgie.newLine();
                        bufferedWriterChirurgie.flush();
                    } else if (medic.specializare.equals("RADIOLOGIE")) {
                        specializare.get("Radiolog").add(medic);
                        bufferedWriterRadiologie.write(text);
                        bufferedWriterRadiologie.newLine();
                        bufferedWriterRadiologie.flush();
                        medic.goingToHospital();

                    } else {
                        specializare.get("Ortoped").add(medic);
                        bufferedWriterOrtopedie.write(text);
                        bufferedWriterOrtopedie.newLine();
                        bufferedWriterOrtopedie.flush();
                        medic.goingToHospital();

                    }
                    if (medic.deTura) {
                        shift.get("onDuty").add(medic);
                        onDuty.add(medic);
                        bufferedWriterOnDuty.write(text);
                        bufferedWriterOnDuty.newLine();
                        bufferedWriterOnDuty.flush();
                    } else {
                        shift.get("offDuty").add(medic);
                        offDuty.add(medic);
                        bufferedWriterNotOnDuty.write(text);
                        bufferedWriterNotOnDuty.newLine();
                        bufferedWriterNotOnDuty.flush();
                    }
                } else {

                    Pacient pacient = new Pacient(array[0], array[1], array[2], array[3]);

                    if (pacient.specializare.equals("CHIRURGIE")) {
                        specializareCautata.get("Chirurgie").add(pacient);
                        pacientiChirurgie.add(pacient);
                        pacient.goingToHospital();
                        countPacientiChirurgie++;
                        bufferedWriterPacientiChirurgie.write(text);
                        bufferedWriterPacientiChirurgie.newLine();
                        bufferedWriterPacientiChirurgie.flush();
                    } else if (pacient.specializare.equals("RADIOLOGIE")) {
                        specializareCautata.get("Radiologie").add(pacient);
                        pacientiRadiologie.add(pacient);
                        pacient.goingToHospital();
                        countPacientiRadiologie++;
                        bufferedWriterPacientiRadiologie.write(text);
                        bufferedWriterPacientiRadiologie.newLine();
                        bufferedWriterPacientiRadiologie.flush();
                    } else {
                        specializareCautata.get("Ortopedie").add(pacient);
                        pacientiOrtopedie.add(pacient);
                        pacient.goingToHospital();
                        countPacientiOrtopedie++;
                        bufferedWriterPacientiOrtopedie.write(text);
                        bufferedWriterPacientiOrtopedie.newLine();
                        bufferedWriterPacientiOrtopedie.flush();
                    }
                }


                text = bufferedReaderHospital.readLine();
            }


            bufferedWriterMedici.close();
            bufferedWriterPacientiChirurgie.close();
            bufferedWriterPacientiRadiologie.close();
            bufferedWriterPacientiOrtopedie.close();
            bufferedWriterChirurgie.close();
            bufferedWriterOrtopedie.close();
            bufferedWriterRadiologie.close();
            bufferedWriterOnDuty.close();
            bufferedWriterNotOnDuty.close();

            ArrayList<Medic> mediciChirurgie = specializare.get("Chirurg");
            for (Medic medic : mediciChirurgie) {
                System.out.println("Doctorii cu specializarea chirurgie sunt :" + medic);
            }

            ArrayList<Medic> mediciRadiologie = specializare.get("Radiolog");
            for (Medic medic : mediciRadiologie) {
                System.out.println("Doctorii cu specializarea radiologie sunt :" + medic);
            }

            ArrayList<Medic> mediciOrtopedie = specializare.get("Ortoped");
            for (Medic medic : mediciOrtopedie) {
                System.out.println("Doctorii cu specializarea ortopedie sunt :" + medic);
            }


            try {
                cabinetChirurgie(pacientiChirurgie);
            } catch (TooCrowdedException e) {
                System.out.println(e.getMessage());
            }


            try {
                cabinetRadiologie(pacientiRadiologie);
            } catch (TooCrowdedException e) {
                System.out.println(e.getMessage());
            }


            try {
                cabinetOrtopedie(pacientiOrtopedie);
            } catch (TooCrowdedException e) {
                System.out.println(e.getMessage());
            }


            try {
                for (Medic medic : onDuty) {
                    System.out.println("Doctorii de tura sunt:" + medic);
                    if (onDuty.isEmpty()) {
                        throw new NobodyOnShiftException("Nu este nimeni de garda.");
                    }
                }
            } catch (NobodyOnShiftException e) {
                System.out.println(e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("A aparut o exceptie " + e.getCause());
        }


    }

    public static void cabinetChirurgie(List pacientiChirurgie) throws TooCrowdedException {

        for (Object pacient : pacientiChirurgie) {
            if (countPacientiChirurgie > 3) {
                throw new TooCrowdedException("Avem prea multi pacienti pentru cabinetul de chirurgie.");
            }

            System.out.println("Pacientii pentru specializarea chirurgie sunt :" + pacient);
        }

    }


    public static void cabinetRadiologie(List pacientiRadiologie) throws TooCrowdedException {
        for (Object pacient : pacientiRadiologie) {
            if (countPacientiRadiologie > 5) {
                throw new TooCrowdedException("Avem prea multi pacienti pentru cabinetul de radiologie.");
            }
            System.out.println("Pacientii pentru specializarea radiologie sunt :" + pacient);
        }

    }


    public static void cabinetOrtopedie(List pacientiOrtopedie) throws TooCrowdedException {
        for (Object pacient : pacientiOrtopedie) {
            if (countPacientiOrtopedie > 5) {
                throw new TooCrowdedException("Avem prea multi pacienti pentru cabinetul de ortopedie.");
            }

            System.out.println("Pacientii pentru specializarea ortopedie sunt :" + pacient);
        }

    }


}
