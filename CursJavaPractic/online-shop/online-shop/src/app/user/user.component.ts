import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
errorMessageName='';
  constructor() { }

  ngOnInit(): void {
  }
  inregistrare():void{
    
  }
  focusOutFunctionName(event:any){
    
    var tastaApasata=event.target.value;
    var txt=tastaApasata.split("");
    for(var courser=0;courser<tastaApasata.length;courser++){
      if(txt[courser]=='0' || txt[courser]=='1' || txt[courser]=='2' || txt[courser]=='3' || txt[courser]=='4' || txt[courser]=='5'
      || txt[courser]=='6' || txt[courser]=='7' || txt[courser]=='8' || txt[courser]=='9'){
        this.errorMessageName='Invalid field ';
        
      }else{
        this.errorMessageName='';
      }
    }

   
  }
  focusOutFunctionSurname(event:any){
    var name=event.target.value;
    
  }
  focusOutFunctionCity(event:any){
    var city=event.target.value;
   
  }
  focusOutFunctionPassword(event:any){
    var password=event.target.value;
  
  }
  focusOutFunctionRepeatPassword(event:any){
    var repeatPassword=event.target.value;
    
  }
}
