public class Porumbel extends Animal implements Ierbivore,Salbatic{
    public String move(){
        return "Zboara...";
    }
    public String eat(){
        return "Porumbelul se hraneste cu seminte...";
    }

    @Override
    public boolean pet() {
        return true;
    }
}
