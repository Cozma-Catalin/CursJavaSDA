import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from './user';
import {Account} from '../account/account'


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  public users=[];
  public errorMsg;
 
  userInfo:User=new User()
 
  name:'';
  surname:'';
  phoneNumber:''; 
  birthDate:'';
  email:'';
  account:Account = new Account ;
  userName:'';   
  password:'';
  
  
  errorMessageName='';
  errorMessageSurname='';
  errorMessagePhoneNumber='';
  errorMessageEmail='';
  errorMessageUserName='';
  errorMessagePassword='';
  errorMessagePasswordLength='';
  

  post_url = 'http://localhost:8080/insertCustomer'


  constructor(private _userService:UserService ) { }

  ngOnInit() {}

  getUser(){
    this._userService.getUsers().subscribe(data => this.users = data,
      error => this.errorMsg = error);

  }

  
  

  
  register(): any {
    
   this._userService.register();
}

  focusoutFunctionName(event:any){
    this.name = event.target.value;
    var txt = this.name.split("");
    for(var i=0; i<this.name.length; i++){
      if(txt[i]=='1' || txt[i]=='2' || txt[i]=='3' || txt[i]=='4' || txt[i]=='5' || txt[i]=='6' || txt[i]=='7' || txt[i]=='8' || txt[i]=='9' || txt[i]=='0'){
        this.errorMessageName='Invalid field !';
      }else{
        this.errorMessageName='';
      }
    }
    this.userInfo.name=this.name;
  }

  focusoutFunctionSurname(event:any){
    this.surname = event.target.value;
    var txt = this.surname.split("");
    for(var i=0; i<this.surname.length ;i++){
      if(txt[i]=='1' || txt[i]=='2' || txt[i]=='3' || txt[i]=='4' || txt[i]=='5' || txt[i]=='6' || txt[i]=='7' || txt[i]=='8' || txt[i]=='9' || txt[i]=='0'){
        this.errorMessageSurname='Invalid field !';
      }else{
        this.errorMessageSurname='';
      }
    }
    this.userInfo.surname=this.surname;
  }

  focusoutFunctionPhoneNumber(event:any){
    this.phoneNumber = event.target.value;
    
      if(this.phoneNumber.length<10){
        this.errorMessagePhoneNumber='Phone number must be 10 characters long !';
      }else{
        this.errorMessagePhoneNumber='';
      }
      
    this.userInfo.phoneNumber=this.phoneNumber;
  }

  focusoutFunctionBirthDate(event:any){
    this.userInfo.birthDate = event.target.value;
    this.userInfo.birthDate=this.birthDate;
  }

  
  focusoutFunctionPassword(event:any){
    this.password = event.target.value;
    if(this.password.length<6){
      this.errorMessagePasswordLength='Password must contain at least 6 characters !';
    }else{
      this.errorMessagePasswordLength='';
      this.account.password=this.password;
    }
    
  }



 

}
