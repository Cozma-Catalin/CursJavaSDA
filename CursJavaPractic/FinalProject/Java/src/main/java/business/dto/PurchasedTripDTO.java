package business.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchasedTripDTO {
    @Valid
    private CustomerDTO customer;

    @Valid
    private TripDTO trip;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfPurchase ;

    @NotNull
    private double totalPrice;

    @NotNull
    private double discount;

}
