import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable()
export class LoginService {

  constructor(private http:HttpClient) { }
  
  login(email:string,password:string): any{
   //const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(email + ':' + password) });
    return this.http.put(
      'http://localhost:8080/api/user/logIn?email='+ email+'&password='+password,{responseType: 'text'})
  }

}
