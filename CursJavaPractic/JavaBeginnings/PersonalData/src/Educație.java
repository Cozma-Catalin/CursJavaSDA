public class Educație {

     String liceu = null;
     String facultate = null;
     
     public Educație(String liceu,String facultate){
         this.liceu = liceu;
         this.facultate = facultate;
     }

    public String toString() {
      return "Am făcut liceul la " + this.liceu + " și facultatea la " + this.facultate + ".";
     }
}
