package business.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripDTO {
    @NotNull
    @NotBlank
    @NotEmpty
    @Pattern(regexp = "([a-z A-Z])*")
    private String name;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.sql.Date departureDate;

    @Valid
    private FlightDTO departureFlight;

    @NotNull
    private java.sql.Date returnDate;

    @Valid
    private FlightDTO returningFlight;

    @Valid
    private HotelDTO stayingHotel;

    @NotNull
    @NotBlank
    @NotEmpty
    @Pattern(regexp = "([a-z A-Z])*")
    private String mealType;

    @NotNull
    private int numberOfDays;

    @NotNull
    private boolean promoted;

    @NotNull
    private double priceForAdult;

    @NotNull
    private double priceForChild;

    @NotNull
    private int numberOfAdults;

    @NotNull
    private int numberOfChildren;

    @NotNull
    private int numberOfTripsAvailable;


}
