package business.dto;



import java.sql.Date;



public class PurchasedTripDTO {

    private CustomerDTO customer;
    private TripDTO trip;
    private Date dateOfPurchase ;
    private double totalPrice;
    private double discount;

    public PurchasedTripDTO() {
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public TripDTO getTrip() {
        return trip;
    }

    public void setTrip(TripDTO trip) {
        this.trip = trip;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setDiscount(double discount){
        this.discount = discount;
    }

    public double getDiscount(){
        return discount;
    }
}
