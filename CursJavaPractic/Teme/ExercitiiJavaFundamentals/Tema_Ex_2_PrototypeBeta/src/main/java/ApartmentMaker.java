public class ApartmentMaker {
    public Apartment makeOneRoomApartment() {
        Apartment oneRoomApartment = new OneRoomApartment("1", "1", true);
        return oneRoomApartment;
    }

    public Apartment makeTwoRoomApartment() {
        Apartment twoRoomApartment = new TwoRoomsApartment("2", "1", true);
        return twoRoomApartment;
    }

    public Apartment makeThreeRoomApartment() {
        Apartment threeRoomApartment = new ThreeRoomApartment("3", "2", true);
        return threeRoomApartment;
    }

    public Apartment makePenthouse() {
        Apartment penthouse = new Penthouse("5", "3", true);
        return penthouse;
    }
}
