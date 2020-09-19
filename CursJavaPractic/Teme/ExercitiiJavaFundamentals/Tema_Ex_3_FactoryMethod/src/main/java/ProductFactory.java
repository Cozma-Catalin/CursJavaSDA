public class ProductFactory {

    public Product getProduct(String productName) {
        if (productName.equals("Cola")) {
            return new ZeroProof("Cola","250 ml", "2.50 lei", true);
        } else if (productName.equals("Fanta")) {
            return new ZeroProof("Fanta","250 ml", "3 lei", true);
        } else if (productName.equals("Prigat")) {
            return new ZeroProof("Prigat","500 ml", "7 lei", false);
        } else if (productName.equals("Tuborg")) {
            return new Beer("Tuborg","500 ml", "7.5 lei", "5.2 %");
        } else if (productName.equals("Becks")) {
            return new Beer("Becks","500 ml", "8 lei", "4.8 %");
        } else if (productName.equals("Carlsberg")) {
            return new Beer("Carlsberg","500 ml", "9 lei", "5 %");
        } else if (productName.equals("Johnny Walker")) {
            return new Spirit("Johnny Walker","750 ml", "75 lei", "40 %");
        } else if (productName.equals("Jameson")) {
            return new Spirit("Jameson","1l", "120 lei", "40 %");
        }
        return null;
    }
}
