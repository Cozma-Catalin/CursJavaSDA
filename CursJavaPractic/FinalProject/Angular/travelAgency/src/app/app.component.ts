import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './user/user';


@Component({ selector: 'app-root',
 templateUrl: 'app.component.html',
 styleUrls: ['./app.component.css']
 })
export class AppComponent implements OnInit {
    title: 'Travel agency';
   


  
    constructor(private http: HttpClient) {
        
     }

    ngOnInit() {      
    }

} 
