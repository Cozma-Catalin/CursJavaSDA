import { HttpClient, HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user/user';
import { Observable } from 'rxjs';




@Injectable()
export class UserService {


  constructor(private http:HttpClient) { }


  
  public addUser(user: User): any{
    return this.http.post("http://localhost:8080/api/user/insert", user,{responseType: 'text'});
  }

  public getUsers(): Observable<User[]>{
    return this.http.get<User[]>('http://localhost:8080/api/user/findUserAccount?email=cozmacatalindaniel99@gmail.com&password=123456');              
  }
    


    checkEmail(email:string): Observable<User[]>{
      return this.http.get<User[]>("http://localhost:8080/api/user/checkEmail?email="+email );
    }

  errorHandler(error: HttpErrorResponse){
    return Observable.throw(error.message || "Server Error");
  }





}

