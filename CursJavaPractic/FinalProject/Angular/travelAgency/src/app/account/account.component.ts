import { Component, OnInit } from '@angular/core';
import { Account} from './account'

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

    personInfo2:Account=new Account();
  
    personInfo:Account={
      id:1 ,
      userName:'',
      password:'',
      confirmPassword:''
    };
  
    errorMessageUserName='';
    errorMessagePassword='';
    errorMessagePasswordLength='';
    userName='';
    password='';
    confirmPassword='';
    
  
    constructor() { }
  
    ngOnInit(): void {
      console.log('jguashdb');
    }
  
    inregistrare(): void{
  
    }
  
    focusoutFunctionUserName(event:any){
      this.userName = event.target.value;
      var txt = this.userName.split("");
      for(var i=0; i<this.userName.length; i++){
        if(txt[i]=='1' || txt[i]=='2' || txt[i]=='3' || txt[i]=='4' || txt[i]=='5' || txt[i]=='6' || txt[i]=='7' || txt[i]=='8' || txt[i]=='9' || txt[i]=='0'){
          this.errorMessageUserName='Invalid field';
        }else{
          this.errorMessageUserName='';
        }
      }
      this.personInfo.userName=this.userName;
    }
  
  
  
    focusoutFunctionPassword(event:any){
      this.password = event.target.value;
      if(this.password.length<8){
        this.errorMessagePasswordLength='Va rugam introduceti o parola de minim 8 caractere';
      }else{
        this.errorMessagePasswordLength='';
      }
      this.personInfo.password=this.password;
    }
  
    focusoutFunctionConfirmPassword(event:any){
      this.confirmPassword = event.target.value;
      if(this.confirmPassword!=this.password){
        this.errorMessagePassword='Parole diferite Incercati din nou';
      }
      else{
        this.errorMessagePassword='';
      }
      this.personInfo.confirmPassword=this.confirmPassword;
    }
  
}
