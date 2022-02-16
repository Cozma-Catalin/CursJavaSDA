import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XMLDemo {
    public static void main(String[] args) {
        try {
         FileOutputStream writeFile = new FileOutputStream(new File("E:\\SDA\\CursJava\\CursJavaPractic\\codeWars\\src\\main\\resources\\Persons.xml"));
            XMLEncoder encoder = new XMLEncoder(writeFile);
            List<Person> persons = new ArrayList<>();
            Person cata = new Person("Java","Cozma Catalin","M","02-09-1989","Calugareni Galati");
            Person marian = new Person("Java","Cozma Marian","M","29-06-1987","Calugareni Galati");
            Person adi =  new Person("Java","Rusu Adriana","F","07-09-1991","Calugareni Galati");
            persons.add(cata);
            persons.add(marian);
            persons.add(adi);
            encoder.writeObject(persons);
            encoder.close();
            writeFile.close();


            FileInputStream readFile = new FileInputStream(new File("E:\\SDA\\CursJava\\CursJavaPractic\\codeWars\\src\\main\\resources\\Persons.xml"));
            XMLDecoder decoder = new XMLDecoder(readFile);

            List<Person> personsList = (List<Person>) decoder.readObject();

            decoder.close();
            readFile.close();

            for(Person p:personsList) {
                System.out.println(p);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }

    }
}
