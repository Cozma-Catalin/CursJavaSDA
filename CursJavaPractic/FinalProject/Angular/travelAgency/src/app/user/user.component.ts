import { HttpClient, HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
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
  private http:HttpClient;
  
  userInfo:User=new User()
 
  name:'';
  surname:'';
  phoneNumber:''; 
  birthDate;
  email:'';
  address:'';
  password:'';
  
  
  errorMessageName='';
  errorMessageSurname='';
  errorMessagePhoneNumber='';
  errorMessageEmail='';
  errorMessagePassword='';
  errorMessagePasswordLength='';
  

  


  constructor(private _userService:UserService ) { }
  
  ngOnInit() {
  
  }

  public getUsers(): void{
    this._userService.getUsers().subscribe(data => this.users = data,
      (error: HttpErrorResponse) => {alert(error.message);
      }
    );
}  


public onAddUser(addForm: NgForm):void{

  this._userService.addUser(addForm.value).subscribe(
    (response: User) => {
      console.log(response);
      addForm.reset();
    },
    (error: HttpErrorResponse) => {
      alert(error.message);
      addForm.reset();
    }
  );
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
    this.birthDate = event.target.value;
    this.userInfo.birthDate=this.birthDate;
  }

  
  focusoutFunctionPassword(event:any){
    this.password = event.target.value;
    if(this.password.length<6){
      this.errorMessagePasswordLength='Password must contain at least 6 characters !';
    }else{
      this.errorMessagePasswordLength='';
      this.password=this.password;
    }
    
  }



 

}
