import { Component, OnInit } from '@angular/core';
import {AccountService} from '../account.service'
@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {
  public users=[];
  
  userName= '';   
  password='';
  confirmPassword='';


  private _userService: any;
  errorMessagePasswordLength: string;
  errorMessageUserName='';
  errorMessagePassword='';
  constructor(private _accountService:AccountService) { 
  }

  ngOnInit() {
    
 
    }


  login(){
    this._accountService.getUsers().subscribe(data => this.users = data);
   

    console.log('Log in succesfull !');
  }

  focusoutFunctionUserName(event:any){
    this.userName = event.target.value;

    this._userService.checkUserName(this.userName).subscribe(data => this.users = data);
    this.userName=this.userName;
  }

  focusoutFunctionPassword(event:any){
    this.password = event.target.value;
    if(this.password.length<6){
      this.errorMessagePasswordLength='Password must contain at least 6 characters !';
    }else{
      this.errorMessagePasswordLength='';
    }
    this.password=this.password;
  }


  focusoutFunctionConfirmPassword(event:any){
    this.confirmPassword = event.target.value;
    if(this.confirmPassword!=this.password){
      this.errorMessagePassword='Passwords not matching !';
    }
    else{
      this.errorMessagePassword='';
      this.confirmPassword=this.confirmPassword;
    }
    
  }
  }

 


