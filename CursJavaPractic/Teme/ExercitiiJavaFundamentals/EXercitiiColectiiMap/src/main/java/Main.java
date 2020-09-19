import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //sa se citeasca dintr un fisier de pe fiecare rand numele,prenumele,clasasi un optional
        // sa se grupeze in colectii diferite elevii in fcr de clasa si in fct de optional


        try {
            String filepath = "C:\\Users\\Catalin\\Desktop\\Elevi.txt";
            FileReader fileReader = new FileReader(filepath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String text = bufferedReader.readLine();
            //creem Map
            Map<String, ArrayList<Student>> clasaEleviMap = new HashMap<>();
            Map<String, ArrayList<Student>> optionalEleviMap = new HashMap<>();
            //pregatimm Map
            clasaEleviMap.put("8", new ArrayList<Student>());
            clasaEleviMap.put("9", new ArrayList<Student>());
            clasaEleviMap.put("10", new ArrayList<Student>());
            clasaEleviMap.put("11", new ArrayList<Student>());
            clasaEleviMap.put("12", new ArrayList<Student>());

            optionalEleviMap.put("Informatica", new ArrayList<Student>());
            optionalEleviMap.put("Engleza", new ArrayList<Student>());
            optionalEleviMap.put("Sport", new ArrayList<Student>());
            optionalEleviMap.put("Mate", new ArrayList<Student>());
            optionalEleviMap.put("Biologie", new ArrayList<Student>());
            optionalEleviMap.put("Fizica", new ArrayList<Student>());
            optionalEleviMap.put("Geografie", new ArrayList<Student>());
            optionalEleviMap.put("Logica", new ArrayList<Student>());


            while (text != null) {
                String[] array = text.split(";");
                Student student = new Student(array[0], array[1], array[2], array[3]);
                //grupam in fct de clasa

                if (student.getGroup().equals("9")) {
                    clasaEleviMap.get("9").add(student);
                } else if (student.getGroup().equals("10")) {
                    clasaEleviMap.get("10").add(student);
                } else if (student.getGroup().equals("11")) {
                    clasaEleviMap.get("11").add(student);
                } else if (student.getGroup().equals("12")) {
                    clasaEleviMap.get("12").add(student);
                } else {
                    clasaEleviMap.get("8").add(student);
                }


                //grupam in fct de optional
                if (student.getOptional().equals("Informatica")) {
                    optionalEleviMap.get("Informatica").add(student);
                } else if (student.getOptional().equals("Mate")) {
                    optionalEleviMap.get("Mate").add(student);
                } else if (student.getOptional().equals("Sport")) {
                    optionalEleviMap.get("Sport").add(student);
                } else if (student.getOptional().equals("Engleza")) {
                    optionalEleviMap.get("Engleza").add(student);
                } else if (student.getOptional().equals("Logica")) {
                    optionalEleviMap.get("Logica").add(student);
                } else if (student.getOptional().equals("Biologie")) {
                    optionalEleviMap.get("Biologie").add(student);
                } else {
                    optionalEleviMap.get("Geografie").add(student);
                }


                text = bufferedReader.readLine();
            }


            //afisam studentii de la info
            ArrayList<Student> studentiInfo = optionalEleviMap.get("Informatica");
            for (Student student : studentiInfo) {
                System.out.println("Studentii la info sunt:" + student);
            }

            //afisam studentii din clasa a 11 a
            ArrayList<Student> studentiClasa_11 = clasaEleviMap.get("11");
            for (Student student : studentiClasa_11) {
                System.out.println("Studentii din clasa a 11 a sunt:" + student);
            }

            //afisam stuentii de la mate
            ArrayList<Student> studentiMate = optionalEleviMap.get("Mate");
            for (Student student : studentiMate) {
                System.out.println("Studentii la mate sunt: " + student);
            }

            //afisam studentii din clasa a 10 a
            ArrayList<Student> studentiClasa_10 = clasaEleviMap.get("10");
            for (Student student : studentiClasa_10) {
                System.out.println("Studentii din clasa a 10 a sunt :" + student);
            }

        } catch (IOException e) {
            System.out.println("A aparut exceptia :" + e.getMessage());
        }


    }
}