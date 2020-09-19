public class Soparla extends Animal implements Omnivore,Salbatic{
    public String move() {
        return "Se taraste...";
    }

    public String eat() {
        return "Soparla mananca insecte...";
    }

    @Override
    public boolean pet() {
        return true;
    }
}
