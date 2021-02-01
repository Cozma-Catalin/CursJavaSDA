import { HttpClient, HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user/user';
import { Observable } from 'rxjs';


@Injectable()
export class UserService {
 
postId;

userInfo:User=new User()
 
name:string;
surname:string;
phoneNumber:string; 
birthDate:string;
address:string;
account:Account;
email:string;
userName:string;   
password:string;

  private _url: string = "http://localhost:8080/findCustomerAccount?userName=ka7a_79&password=123456";

  private post_url = 'http://localhost:8080/insertCustomer';

  constructor(private http:HttpClient) { }

  register() :any{
    const body ={name:this.name,
      surname:this.surname,
      birthDate:this.birthDate,
      address:this.address,
      phoneNumber:this.phoneNumber,
      email:this.email,  
       account:{
          userName:this.userName,
          password:this.password
      }};
    this.http.post<any>(this.post_url,body
      ).toPromise().then((data: any) => {
        console.log(data);
    })
}

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