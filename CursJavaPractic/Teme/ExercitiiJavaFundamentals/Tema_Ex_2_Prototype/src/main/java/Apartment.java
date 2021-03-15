public class Apartment {
    private String numberOfRooms;
    private String numberOfBathRooms;
    private boolean balcony;

    public Apartment() {

    }

    public Apartment(String numberOfRooms, String numberOfBathRooms, boolean balcony) {
        this.numberOfRooms = numberOfRooms;
        this.numberOfBathRooms = numberOfBathRooms;
        this.balcony = balcony;
    }

    public Apartment clone() {
        return new Apartment(this.numberOfRooms, this.numberOfBathRooms, this.balcony);
    }

    public String getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(String numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getNumberOfBathRooms() {
        return numberOfBathRooms;
    }

    public void setNumberOfBathRooms(String numberOfBathRooms) {
        this.numberOfBathRooms = numberOfBathRooms;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    @Override
    public String toString() {
        return  numberOfRooms + " number of rooms," + numberOfBathRooms + " number of bathrooms and the status of the balcony is " + balcony ;
    }
}
