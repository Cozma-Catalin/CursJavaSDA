package business.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightDTO {
    @NotNull
    private String flightNumber;

    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date departureDate;

    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss",timezone = "Europe/Bucharest")
    private Timestamp departureTime;

    @Valid
    private AirportDTO departureAirport;

    @NotNull
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date arrivingDate;

    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss",timezone = "Europe/Bucharest")
    private Timestamp arrivingTime;

    @Valid
    private AirportDTO arrivingAirport;

    @NotNull
    private double price;

    @NotNull
    private int seatsAvailable;




}
