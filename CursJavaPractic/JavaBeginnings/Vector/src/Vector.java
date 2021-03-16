public class Vector {
    public static void main(String[] args){
        int an = 1501;
        int[] arrayani = new int[1600];

        int anfinal = 1600;
        while(an<=anfinal){
          arrayani[an-1] = an;

          an++;

        }
        afiseazaAni(arrayani);
        aniBisect(arrayani);

    }
    public static void afiseazaAni(int[] parametru){
        for(int cursor = 1500;cursor<parametru.length;cursor++) {
            System.out.println(parametru[cursor]);
        }
    }
    public static void aniBisect(int[] parametru1){
        for(int cursor = 1500;cursor<parametru1.length;cursor++){
            if(parametru1[cursor]%4==0){

                System.out.println(parametru1[cursor]);
            }

        }
    }


}
