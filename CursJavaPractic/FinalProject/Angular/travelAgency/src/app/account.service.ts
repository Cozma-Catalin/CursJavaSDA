import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user/user';


@Injectable()
export class AccountService {


constructor(private http:HttpClient) { }

public getUsers(): Observable<User[]>{
  return this.http.get<User[]>('http://localhost:8080/api/user/findUserAccount?email=cozmacatalindaniel99@gmail.com&password=123456');              
}

}