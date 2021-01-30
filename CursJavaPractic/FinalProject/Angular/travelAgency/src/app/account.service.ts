import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user/user';

@Injectable()
export class AccountService {

private _url: string = "http://localhost:8080/findCustomerAccount?userName=ka7a_79&password=123456";

constructor(private http:HttpClient) { }

  getUsers(): Observable<User[]>{
    return this.http.get<User[]>(this._url);              
  }
    

errorHandler(error: HttpErrorResponse){
  return Observable.throw(error.message || "Server Error");
  }

}