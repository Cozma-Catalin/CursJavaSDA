package business.dto;



import java.sql.Date;
import java.time.LocalDateTime;


public class PurchasedTripDTO {

    private CustomerDTO customerDTO;
    private TripDTO tripDTO;
    private Date dateOfPurchase ;
    private double totalPrice;
    private double discount;

    public PurchasedTripDTO() {
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public TripDTO getTripDTO() {
        return tripDTO;
    }

    public void setTripDTO(TripDTO tripDTO) {
        this.tripDTO = tripDTO;
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
