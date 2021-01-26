export class Trip {

    name:string;
    departureDate: string;
    departureFlight: Flight;  
    returnDate: string;
    returningFlight: Flight;    
    stayingHotel: Hotel; 
    mealType: string;
    numberOfDays: number;
    promoted: boolean;
    priceForAdult: number;
    priceForChild: number;
    numberOfAdults: number;
    numberOfChildren: number;
    numberOfTripsAvailable: number;
    }
  
  class Hotel{
    name: string;
    address: string;
    numberOfStars: number;
    description: string;
    cityDTO: City;
    rooms: Room[];
  }  
  
  class Room{
    roomType: string;
    numberOfRooms: number;
    extraBed: boolean;
    price: number;
    roomsAvailable: number;
  }
  
  class Flight{
    flightNumber:string;
    departureDate: string;
    departureTime: string;
    departureAirport: Airport;
    arrivingDate: string;
    arrivingTime: string;
    arrivingAirport: Airport;
    price: number;
    seatsAvailable: number;
  }
  
  class Airport{
    name: string;
    city: City;
  }
  
  class City{
    name:string;
    country:Country;
  }
  
  class Country{
    name:string;
    continent:Continent;
  }
  
  class Continent{
    name:string;
  }
  
  