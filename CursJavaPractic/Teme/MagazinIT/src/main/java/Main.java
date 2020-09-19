import Exceptions.NotEnaughMoneyException;
import Exceptions.NotEnaughQuantityException;

public class Main {
    public static void main(String[] args) {
        //magazin echipamente IT
        //fisiere separate(nume,pret,cantitate)
        //
        //1.PC(unitate),LAPTOPURI,Monitoare,
        //2.tastaturi,mouse,web cam(periferice)
        //3.harddissk ,mem ram,procesoare,placi video(componente)
        //
        //-meniu -->1.cumpara un laptop ,2.un pc ,3.periferice si 4.componenete
        //-->dupa alegere sa se ofere posibilitatea de a upgrada obiectul....(EX: sa inlocuiasca hardul cu un ssd---> placa video curenta cu una mai buna)
        //-->msg final sistemul dvs costa atat si desccrierea obiectelor si cumparati sau nu
        LapTopFileReader lapTopFileReader = new LapTopFileReader();
        lapTopFileReader.readLapTopFile();

        PCFileReader pcFileReader = new PCFileReader();
        pcFileReader.readPCFile();

        MonitorFileReader monitorFileReader = new MonitorFileReader();
        monitorFileReader.readMonitorFile();

        ComponentFileReader componentFilereader = new ComponentFileReader();
        componentFilereader.readComponentFile();

        PerifericalsFileReader perifericalsFileReader = new PerifericalsFileReader();
        perifericalsFileReader.readPerifericalsFile();


        User user = new User(300000);
        try {
            user.browseMeniu();

        } catch (NotEnaughMoneyException | NotEnaughQuantityException e) {
            System.out.println(e.getMessage());
        }
    }
}
