import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from './user';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  public users=[];
  public errorMsg;
 
  userInfo:User=new User()
 
  firstName='';
  lastName='';
  city=''; 
  dateOfBirth='';
  email='';
  userName= '';   
  password='';
  confirmPassword='';
  
  errorMessageFirstName='';
  errorMessageLastName='';
  errorMessageCity='';
  errorMessageEmail='';
  errorMessageUserName='';
  errorMessagePassword='';
  errorMessagePasswordLength='';
  




  constructor(private _userService:UserService ) { }

  ngOnInit() {}

  getUser(){
    this._userService.getUsers().subscribe(data => this.users = data,
      error => this.errorMsg = error);

  }

  
  register(): void{

  }

  focusoutFunctionFirstName(event:any){
    this.firstName = event.target.value;
    var txt = this.firstName.split("");
    for(var i=0; i<this.firstName.length; i++){
      if(txt[i]=='1' || txt[i]=='2' || txt[i]=='3' || txt[i]=='4' || txt[i]=='5' || txt[i]=='6' || txt[i]=='7' || txt[i]=='8' || txt[i]=='9' || txt[i]=='0'){
        this.errorMessageFirstName='Invalid field !';
      }else{
        this.errorMessageFirstName='';
      }
    }
    this.userInfo.firstName=this.firstName;
  }

  focusoutFunctionLastName(event:any){
    this.lastName = event.target.value;
    var txt = this.lastName.split("");
    for(var i=0; i<this.lastName.length ;i++){
      if(txt[i]=='1' || txt[i]=='2' || txt[i]=='3' || txt[i]=='4' || txt[i]=='5' || txt[i]=='6' || txt[i]=='7' || txt[i]=='8' || txt[i]=='9' || txt[i]=='0'){
        this.errorMessageLastName='Invalid field !';
      }else{
        this.errorMessageLastName='';
      }
    }
    this.userInfo.lastName=this.lastName;
  }

  focusoutFunctionCity(event:any){
    this.city = event.target.value;
    var txt = this.city.split("");
    for(var i=0; i<this.city.length; i++){
      if(txt[i]=='1' || txt[i]=='2' || txt[i]=='3' || txt[i]=='4' || txt[i]=='5' || txt[i]=='6' || txt[i]=='7' || txt[i]=='8' || txt[i]=='9' || txt[i]=='0'){
        this.errorMessageCity='Invalid field !';
      }else{
        this.errorMessageCity='';
      }
    }
    this.userInfo.city=this.city;
  }

  focusoutFunctionDateOfBirth(event:any){
    this.userInfo.dateOfBirth = event.target.value;
    this.userInfo.dateOfBirth=this.dateOfBirth;
  }

  
  focusoutFunctionUserName(event:any){
    this.userName = event.target.value;

    this._userService.checkUserName(this.userName).subscribe(data => this.users = data,
      error => this.errorMsg = error);
    this.userInfo.userName=this.userName;
  }

  focusoutFunctionPassword(event:any){
    this.password = event.target.value;
    if(this.password.length<8){
      this.errorMessagePasswordLength='Password must contain at least 8 characters !';
    }else{
      this.errorMessagePasswordLength='';
    }
    this.userInfo.password=this.password;
  }

  focusoutFunctionConfirmPassword(event:any){
    this.confirmPassword = event.target.value;
    if(this.confirmPassword!=this.password){
      this.errorMessagePassword='Passwords not matching !';
    }
    else{
      this.errorMessagePassword='';
    }
    this.userInfo.confirmPassword=this.confirmPassword;
  }

  focusoutFunctionEmail(event:any){
    this.email = event.target.value;
    
    this._userService.checkEmail(this.email).subscribe(data => this.users = data,
      error => this.errorMsg = error);
    this.userInfo.email=this.email;
  }
}
