import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Trip } from './trip/trip';
import { Observable } from 'rxjs';

@Injectable()
export class TripService {

  private _url: string = "http://localhost:8080/findAllTrips";

  constructor(private http:HttpClient) { }

    getTrips(): Observable<Trip[]>{
      return this.http.get<Trip[]>(this._url);
                      
    }
      
  


  errorHandler(error: HttpErrorResponse){
    return Observable.throw(error.message || "Server Error");
  }

}