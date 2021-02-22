import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Trip } from './trip/trip';
import { Observable } from 'rxjs';


@Injectable()
export class TripService {

 

  constructor(private http:HttpClient) { }

    getTrips(): Observable<Trip[]>{
      return this.http.get<Trip[]>("http://localhost:8080/api/trip/findAll");
                      
    }
      
  


  errorHandler(error: HttpErrorResponse){
    return Observable.throw(error.message || "Server Error");
  }

}