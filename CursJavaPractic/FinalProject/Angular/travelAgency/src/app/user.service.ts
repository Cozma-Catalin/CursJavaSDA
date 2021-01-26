import { HttpClient, HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user/user';
import { Observable } from 'rxjs';


@Injectable()
export class UserService {
 

 


  private _url: string = "http://localhost:8080/findCustomerAccount?userName=ka7a_79&password=123456";

  constructor(private http:HttpClient) { }

    getUsers(): Observable<User[]>{
      return this.http.get<User[]>(this._url);
                      
    }

    checkUserName(userName:string): Observable<User[]>{
      return this.http.get<User[]>("http://localhost:8080/checkUserName?userName="+userName);
    }

    checkEmail(email:string): Observable<User[]>{
      return this.http.get<User[]>("http://localhost:8080/checkEmail?email="+email );
    }

  errorHandler(error: HttpErrorResponse){
    return Observable.throw(error.message || "Server Error");
  }





}