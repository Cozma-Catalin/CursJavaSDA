public class exercitii {
    public static void main(String[] args){
        int x=23457;

        if(x%7==0){
            System.out.println("Numarul se imparte la 7.");

        }else {
            System.out.println("Numarul nu se imparte la 7.");
        }
    }


    String text = "nbgaf sagasuastgvjht8oiuhkjsb  buisgafuayfoiasjf;ksahusatubs,ma fuastfysafasnbkhgbyuthafbhagfukajifoas kjagufhusfdlskfhoishflekf dsjlhfouehsfoihsk3jdfgusdglkejioeg dlihowhgoiwehginkudsjnwelgdsnkansohd ";
int pozitie = 300;
int lungimeText = text.length();
   if (lungimeText < pozitie) {
        System.out.println("Textul dv este mai mare decat pozitia data.");
        } else {
        char caracterCautat=text.charAt(pozitie);
        System.out.println("Caracterul este: "+caracterCautat);
        }


        }


}