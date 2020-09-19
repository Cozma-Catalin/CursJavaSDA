public class CalculatorStringuri extends CalculatorStiintific{
    String text1 = " Let us now look deep into what are objects. If we consider the real-world, we can find many objects around us, cars, dogs, humans, etc. All these objects have a state and a behavior.";
    String text2 = "If we consider a dog, then its state is - name, breed, color, and the behavior is - barking, wagging the tail, running.";
    String lit = "a";
    public CalculatorStringuri() {

    }

    public CalculatorStringuri(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
    }

    public String concat(String text1, String text2) {
        return text1.concat(text2);
    }

    public boolean containsChar(String text1,String lit) {
        if (text1.contains(lit)) {
            return true;
        } else {
            return false;
        }
    }

    public int lungimeaTextelor(String text1, String text2) {
        return text1.length() + text2.length();
    }

    public String parSauImpar(String text1) {
        if (text1.length() % 2 == 0) {
            return "Lungimea textului este un nr. par.";
        } else {
            return "Lungimea textului este un nr. impar.";
        }
    }

    public char[] sirChars(String text1) {
        char[] sirChar = text1.toCharArray();
        return sirChar;
    }

    public boolean incepeCuVocala(String text1) {
        if (text1.startsWith("a") || text1.startsWith("e") || text1.startsWith("i") || text1.startsWith("o") || text1.startsWith("u")) {
            return true;
        } else {
            return false;
        }
    }

    public int nrSpatii(String text1) {
        int count = 0;
        for (int i = 0; i < text1.length(); i++) {
            if (text1.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }
}
