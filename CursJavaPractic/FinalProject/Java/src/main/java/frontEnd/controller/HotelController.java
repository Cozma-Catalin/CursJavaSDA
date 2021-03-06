package frontEnd.controller;

import business.dto.HotelDTO;
import business.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping(path = "/api/hotel")
public class HotelController {
    @Autowired
    HotelService hotelService;

    @PostMapping(path = "/insert")
 //   @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity insertHotel(@RequestBody @Valid HotelDTO hotelDTO) {
        List<String> addressList = hotelService.countHotelAddress(hotelDTO.getAddress());
        if (addressList.contains(hotelDTO.getAddress())) {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(hotelDTO.getName() + " with address:'" + hotelDTO.getAddress() + "' is already in the database.");
        }
        hotelService.insertHotelDTO(hotelDTO);
        return ResponseEntity.ok(hotelDTO.getName() + " added.");
    }

    @GetMapping(path = "/findInCity")
 //   @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity findHotelsInCity(@RequestParam String cityName) {
        List<HotelDTO> hotelDTOList = hotelService.findHotelsInCity(cityName);
        if (hotelDTOList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hotels found in city: " + cityName);
        }
        return ResponseEntity.ok(hotelDTOList);
    }

    @GetMapping(path = "/findByName")
   // @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity findHotelByName(@RequestParam String hotelName) {
        List<HotelDTO> hotelDTOList = hotelService.findHotel(hotelName);
        if (hotelDTOList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(hotelName + " can't be found in database.");
        }
        return ResponseEntity.ok(hotelDTOList);
    }

    @DeleteMapping(path = "/deleteByName")
   // @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity deleteHotelByName(@RequestParam String hotelName) {
        if (hotelService.countHotelName(hotelName) == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(hotelName + " can't be found in database.");
        }
        hotelService.deleteHotelByName(hotelName);
        return ResponseEntity.ok(hotelName + " deleted.");
    }

    @DeleteMapping(path = "/deleteByAddress")
  //  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity deleteHotelByAddress(@RequestParam String address) {
        List<String> addressList = hotelService.countHotelAddress(address);
        if (addressList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hotel can be found with address '" + address + "' in database.");
        }
        hotelService.deleteHotelByAddress(address);
        return ResponseEntity.ok("Hotel deleted.");
    }


    @PutMapping(path = "/changeName")
   // @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
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


    @GetMapping(path = "findByAddress")
  //  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity findHotelByAddress(@RequestParam String address) {
        HotelDTO hotelDTO = hotelService.findHotelByAddress(address);
        if (hotelDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can't find any hotel with the address: " + address);
        }
        return ResponseEntity.ok(hotelDTO);
    }

}
