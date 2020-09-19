import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<String, ArrayList<Apartment>> apartmentBuilding = new HashMap<>();
        apartmentBuilding.put("floorA", new ArrayList<>());
        apartmentBuilding.put("floorB", new ArrayList<>());
        apartmentBuilding.put("floorC", new ArrayList<>());
        apartmentBuilding.put("floorD", new ArrayList<>());


        Apartment _1A = new Apartment("1", "1", false);
        Apartment _2A = _1A.clone();
        _2A.setBalcony(true);
        Apartment _3A = _1A.clone();
        Apartment _4A = _2A.clone();
        Apartment _5A = _1A.clone();
        Apartment _6A = _2A.clone();
        apartmentBuilding.get("floorA").add(_1A);
        apartmentBuilding.get("floorA").add(_2A);
        apartmentBuilding.get("floorA").add(_3A);
        apartmentBuilding.get("floorA").add(_4A);
        apartmentBuilding.get("floorA").add(_5A);
        apartmentBuilding.get("floorA").add(_6A);
        ArrayList<Apartment> apartmentsFloorA = apartmentBuilding.get("floorA");


        Apartment _1B = _2A.clone();
        _1B.setNumberOfRooms("2");
        Apartment _2B = _1B.clone();
        Apartment _3B = _1B.clone();
        Apartment _4B = _1B.clone();
        apartmentBuilding.get("floorB").add(_1B);
        apartmentBuilding.get("floorB").add(_2B);
        apartmentBuilding.get("floorB").add(_3B);
        apartmentBuilding.get("floorB").add(_4B);
        ArrayList<Apartment> apartmentsFloorB = apartmentBuilding.get("floorB");

        Apartment _1C = new Apartment("3", "2", true);
        Apartment _2C = _1C.clone();
        Apartment _3C = _1C.clone();
        Apartment _4C = _1C.clone();
        apartmentBuilding.get("floorC").add(_1C);
        apartmentBuilding.get("floorC").add(_2C);
        apartmentBuilding.get("floorC").add(_3C);
        apartmentBuilding.get("floorC").add(_4C);
        ArrayList<Apartment> apartmentsFloorC = apartmentBuilding.get("floorC");

        Apartment _1D = new Apartment("5", "3", true);
        Apartment _2D = _1D.clone();
        apartmentBuilding.get("floorD").add(_1D);
        apartmentBuilding.get("floorD").add(_2D);
        ArrayList<Apartment> apartmentsFloorD = apartmentBuilding.get("floorD");

        for (Apartment apartment : apartmentsFloorA) {
            System.out.println("This apartment on floor A has: " + apartment);
        }

        for (Apartment apartment : apartmentsFloorB) {
            System.out.println("This apartment on floor B has: " + apartment);
        }

        for (Apartment apartment : apartmentsFloorC) {
            System.out.println("This apartment on floor C has: " + apartment);
        }

        for (Apartment apartment : apartmentsFloorD) {
            System.out.println("The apartments on floor D are penthouses an they have: " + apartment);
        }

    }
}
