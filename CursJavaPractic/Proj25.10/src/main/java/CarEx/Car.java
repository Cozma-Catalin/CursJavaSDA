package CarEx;
public class Car {
    protected String mark;

    public Car(String mark) {
        this.mark = mark;
    }

    public Car() {
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Car: " + mark ;
    }
}
