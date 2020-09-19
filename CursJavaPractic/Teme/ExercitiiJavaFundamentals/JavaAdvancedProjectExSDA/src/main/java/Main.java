import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;
import java.time.Year;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//1.modelam SDA
//   -Trainnerul-nume,prenume,data nasterii,autorizat sau nu ?
//   -Trainee -nume,prenume,data nasterii,cunostinte in prog ? si sa nu avem duplicate
//   -Grupa - nume,Trainer,colectie ptr trainee(Set)
//   -Trainee ii luam din fisier(15 studenti)
//   -Grupele le luam dintr un fisier(nume si trainner)
//   - O grupa poate sa aiba max 5 studenti->Exceptie MaximumNumberOfStudentsReached
//   -Afisam grupele care au nr max de studenti
//   -Afisam studentii care au mai putin de 25 de ani
//   -Afisam toti studentii care mai au cunostinte de programare
//   -Afisam grupa care are cei mai multi studenti care nu au cunostinte de programare

        Set<Trainee> studentSetGalati = new HashSet<>();
        Set<Trainee> studentSetIasi = new HashSet<>();
        Set<Trainee> studentSetCluj = new HashSet<>();

        Group groupGalati = null;
        Group groupIasi = null;
        Group groupCluj = null;

        try {
            String filePathStudentiGalati = "C:\\Users\\Catalin\\Desktop\\StudentiGalati.txt";
            FileWriter fileWriterGalati = new FileWriter(filePathStudentiGalati);
            BufferedWriter bufferedWriterGalati = new BufferedWriter(fileWriterGalati);

            String filePathStudentiIasi = "C:\\Users\\Catalin\\Desktop\\StudentiIasi.txt";
            FileWriter fileWriterIasi = new FileWriter(filePathStudentiIasi);
            BufferedWriter bufferedWriterIasi = new BufferedWriter(fileWriterIasi);

            String filePathStudentiCluj = "C:\\Users\\Catalin\\Desktop\\StudentiCluj.txt";
            FileWriter fileWriterCluj = new FileWriter(filePathStudentiCluj);
            BufferedWriter bufferedWriterCluj = new BufferedWriter(fileWriterCluj);


            String filePathStudenti = "C:\\Users\\Catalin\\Desktop\\Studenti.txt";
            FileReader fileReaderStudenti = new FileReader(filePathStudenti);
            BufferedReader bufferedReaderStudenti = new BufferedReader(fileReaderStudenti);

            String text = bufferedReaderStudenti.readLine();
            while (text != null && !text.isEmpty()) {
                String[] arrayStudent = text.split(";");
                Trainee trainee = new Trainee(arrayStudent[0],arrayStudent[1], arrayStudent[2], Boolean.valueOf(arrayStudent[3]),arrayStudent[4]);

                if (arrayStudent[4].equalsIgnoreCase("Galati")) {
                    if (studentSetGalati.size() == 5) {
                        for(Trainee student : studentSetGalati) {
                            System.out.println(student);
                        }
                        throw new MaximumNumbersOfStudentsReached("Grupa este full.");

                    } else {
                        studentSetGalati.add(trainee);
                        bufferedWriterGalati.write(text);
                        bufferedWriterGalati.newLine();
                        bufferedWriterGalati.flush();
                    }
                } else if (arrayStudent[4].equalsIgnoreCase("Iasi")) {
                    if (studentSetIasi.size() == 5) {
                        for(Trainee student : studentSetIasi) {
                            System.out.println(student);
                        }
                        throw new MaximumNumbersOfStudentsReached("Grupa este full.");
                    } else {
                        studentSetIasi.add(trainee);
                        bufferedWriterIasi.write(text);
                        bufferedWriterIasi.newLine();
                        bufferedWriterIasi.flush();
                    }
                } else if (arrayStudent[4].equalsIgnoreCase("Cluj")) {
                    if (studentSetCluj.size() == 5) {
                        for(Trainee student : studentSetCluj) {
                            System.out.println(student);
                        }
                        throw new MaximumNumbersOfStudentsReached("Grupa este full.");
                    } else {
                        studentSetCluj.add(trainee);
                        bufferedWriterCluj.write(text);
                        bufferedWriterCluj.newLine();
                        bufferedWriterCluj.flush();
                    }
                }
                text = bufferedReaderStudenti.readLine();
            }

            bufferedWriterGalati.close();
            bufferedWriterIasi.close();
            bufferedWriterCluj.close();
        } catch (IOException | MaximumNumbersOfStudentsReached e) {
            System.out.println(e.getMessage());
        }


        try {
            String filePathGroup = "C:\\Users\\Catalin\\Desktop\\Group.txt";
            FileReader fileReaderGroup = new FileReader(filePathGroup);
            BufferedReader bufferedReaderGroup = new BufferedReader(fileReaderGroup);
            String text = bufferedReaderGroup.readLine();
            while (text != null && !text.isEmpty()) {
                String[] arrayGroup = text.split(";");
                Trainer trainer = new Trainer(arrayGroup[1], arrayGroup[2], "1988", true);
                if (arrayGroup[0].contains("Galati")) {
                    groupGalati = new Group(arrayGroup[0], trainer, studentSetGalati);
                } else if (arrayGroup[0].contains("Iasi")) {
                    groupIasi = new Group(arrayGroup[0], trainer, studentSetIasi);
                } else if (arrayGroup[0].contains("Cluj")) {
                    groupCluj = new Group(arrayGroup[0], trainer, studentSetCluj);
                }
                text = bufferedReaderGroup.readLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        SoftwareDevelopmentAcademy softwareDevelopmentAcademy = SoftwareDevelopmentAcademy.getInstance();
        softwareDevelopmentAcademy.setGroup(groupGalati);


        sortTraineesAfterAge(studentSetGalati);
        sortTraineesAfterAge(studentSetIasi);
        sortTraineesAfterAge(studentSetCluj);


        sortTrainnesAfterKnowledge(groupGalati);
        sortTrainnesAfterKnowledge(groupIasi);
        sortTrainnesAfterKnowledge(groupCluj);




    }


    public static void sortTraineesAfterAge(Set<Trainee> traineeSet) {
        for (Trainee trainee : traineeSet) {
            if (Year.now().getValue() - Integer.valueOf(trainee.getDateOfBirth()) <= 25) {
                System.out.println("Studentii cu varsta sub 25 ani sunt: " + trainee);
            }
        }
    }

    public static void sortTrainnesAfterKnowledge(Group group) {
        for (Trainee trainee : group.getTrainees()) {
            if (trainee.getPriorKnowledge().startsWith("This")) {
                System.out.println(trainee);
            }
        }
    }

    public static void displayFullGroup(Group group){
        if(group.getTrainees().size() == 5){
            System.out.println(group.getTrainees());
        }
    }
}
