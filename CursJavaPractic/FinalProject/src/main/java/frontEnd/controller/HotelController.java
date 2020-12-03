package frontEnd.controller;

import business.dto.HotelDTO;
import business.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class HotelController {
    @Autowired
    HotelService hotelService;

    @PostMapping(path = "insertHotel")
    public ResponseEntity insertHotel(@RequestBody @Valid HotelDTO hotelDTO) {
        List<String> addressList = hotelService.countAddressInCity(hotelDTO.getCityDTO().getName());
        if (addressList.contains(hotelDTO.getAddress())) {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(hotelDTO.getName() + " with address:'" + hotelDTO.getAddress() +"' is already in the database.");
        }
        hotelService.insertHotelDTO(hotelDTO);
        return ResponseEntity.ok(hotelDTO.getName() + " added.");
    }

    @GetMapping(path = "/findHotelsInCity")
    public ResponseEntity findHotelsInCity(@RequestParam String cityName) {
        List<HotelDTO> hotelDTOList = hotelService.findHotelsInCity(cityName);
        if (hotelDTOList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hotels found in city: " + cityName);
        }
        return ResponseEntity.ok(hotelDTOList);
    }

    @DeleteMapping(path = "/deleteHotelByName")
    public ResponseEntity deleteHotelByName(@RequestParam String hotelName) {
        List<HotelDTO> hotelDTOList = hotelService.findHotel(hotelName);
        if (hotelDTOList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(hotelName + " can't be found in database.");
        }
        hotelService.deleteHotelByName(hotelName);
        return ResponseEntity.ok(hotelName + " deleted.");
    }

    @DeleteMapping(path = "/deleteHotelByAddress")
    public ResponseEntity deleteHotelByAddress(@RequestParam String address) {
        int result = hotelService.deleteHotelByAddress(address);
        if (result == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hotel can be found with address '" + address + "' in database.");
        }
        return ResponseEntity.ok("Hotel deleted.");
    }


    @PutMapping(path = "/changeHotelName")
    public ResponseEntity changeHotelName(@RequestParam String newName, String name) {

        if (hotelService.findHotel(name).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(name + " can't be found in database.");
        }
        if (hotelService.countHotelName(newName) != 0) {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(newName + " is being used...");
        }
        hotelService.changeHotelName(newName, name);
        return ResponseEntity.ok(name + " changed to: " + newName);
    }


    @GetMapping(path = "findHotelByAddress")
    public ResponseEntity findHotelByAddress(@RequestParam String address){
        HotelDTO hotelDTO = hotelService.findHotelByAddress(address);
        if(hotelDTO == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can't find any hotel with the address: " + address);
        }
        return ResponseEntity.ok(hotelDTO);
    }

}
