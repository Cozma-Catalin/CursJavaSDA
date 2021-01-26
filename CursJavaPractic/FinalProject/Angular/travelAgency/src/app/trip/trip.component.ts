import { Component, OnInit } from '@angular/core';
import {TripService} from '../trip.service'

@Component({
  selector: 'app-trip',
  templateUrl: './trip.component.html',
  styleUrls: ['./trip.component.css']
})
export class TripComponent implements OnInit {
  public trips=[];
  public errorMsg;
 

  constructor(private _tripService:TripService) { 
  }

  ngOnInit() {
    this._tripService.getTrips().subscribe(data => this.trips = data,
      error => this.errorMsg = error);
  }

}
