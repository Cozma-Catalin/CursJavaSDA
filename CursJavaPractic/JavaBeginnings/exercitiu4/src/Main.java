

public class Main {
    public static void main(String[] args){
        int zi = 1;
        int ultimaZi = 28;

        int ziua = 1;
        int[] zile = new int[28];
        int ultimazi = 28;

        while(ziua<=ultimazi){
            zile[ziua-1] = ziua;

            ziua++;}
            System.out.println("Ziua este " + zile[5]);

        for(int cursor =0;cursor < 28; cursor++){
            System.out.println(zile[cursor]);
        }
        while(zi<ultimaZi){
            if(zi%7==0){
                System.out.println("Duminică.");
                System.out.println(zi);
            }else if(zi%6==0){
                System.out.println("Sâmbătă.");
                System.out.println(zi);
            }else{
                System.out.println("Zi normală de săptămână.");
            }
           zi ++;
        }
            if(zi==ultimaZi){
                System.out.println("Sfărșit de lună.");
            }
            int primaLuna = 1;
            int ultimaLuna = 12;
           while(primaLuna<=ultimaLuna){
               switch(primaLuna){
                   case 1:
                       System.out.println("Ianuarie.");
                       break;
                   case 2:
                       System.out.println("Februarie.");
                       break;
                   case 3:
                       System.out.println("Martie.");
                       break;
                   case 4:
                       System.out.println("Aprilie.");
                       break;
                   case 5:
                       System.out.println("Mai.");
                       break;
                   case 6:
                       System.out.println("Iunie.");
                       break;
                   case 7:
                       System.out.println("Concediu.");
                       break;
                   case 8:
                       System.out.println("August.");
                       break;
                   case 9:
                       System.out.println("Incepe scoala.");
                       break;
                   case 10:
                       System.out.println("Octombrie.");
                       break;
                   case 11:
                       System.out.println("Noiembrie.");
                       break;
                   case 12:
                       System.out.println("Craciun.");
                       break;
                   default:
                       System.out.println("Nu recunosc luna.");
               }
               primaLuna++;
           }
    }


}
