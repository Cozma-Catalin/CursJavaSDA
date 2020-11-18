package frontEnd.controller;

import business.dto.HotelDTO;
import business.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class HotelController {
    @Autowired
    HotelService hotelService;

    @PostMapping(path = "insertHotel")
    public ResponseEntity insertHotel(@RequestBody @Valid HotelDTO hotelDTO){
        if(hotelService.countHotelDTO(hotelDTO.getCityDTO().getName())!=0){
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(hotelDTO.getName() + " is already in the database.");
        }
        hotelService.insertHotelDTO(hotelDTO);
        return ResponseEntity.ok(hotelDTO.getName() + " added.");
    }
}
