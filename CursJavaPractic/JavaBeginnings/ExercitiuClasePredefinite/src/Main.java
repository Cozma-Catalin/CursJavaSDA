import org.w3c.dom.ls.LSOutput;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {


        //data actuala
        Date dataAzi = new Date();
        System.out.println(dataAzi);
        //luna curenta

        int month = Calendar.getInstance().get(Calendar.MONTH);
        System.out.println(month);
        //anul curent
        System.out.println(Calendar.getInstance().get(Calendar.YEAR));
        //cream un obiect care sa tina un text
        //ultima aparitie a caract 'a' din textul respectiv
        //cream un obiect care sa tina nr:378821
        //cream un obiect care sa tina un 1caract al numelui
        //ptr fiecare obiect sa cautam cate 2 methode
    }

}