import { Component, OnInit } from '@angular/core';
import { Person } from './person';

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent implements OnInit {

  personInfo2:Person=new Person();

  personInfo:Person={
    nume:'',
    prenume:'',
    dataNasterii:'',
    oras:'',
    parola:'',
    confirmare:'',
    email:''
  };

  errorMessageNume='';
  errorMessagePrenume='';
  errorMessageOras='';
  errorMessagePassword='';
  errorMessagePasswordLength='';
  nume='';
  prenume='';
  oras='';
  data='';
  parola='';
  confirmare='';
  email='';
  

  constructor() { }

  ngOnInit(): void {
  }

  inregistrare(): void{

  }

  focusoutFunctionNume(event:any){
    this.nume = event.target.value;
    var txt = this.nume.split("");
    for(var i=0; i<this.nume.length; i++){
      if(txt[i]=='1' || txt[i]=='2' || txt[i]=='3' || txt[i]=='4' || txt[i]=='5' || txt[i]=='6' || txt[i]=='7' || txt[i]=='8' || txt[i]=='9' || txt[i]=='0'){
        this.errorMessageNume='Invalid field';
      }else{
        this.errorMessageNume='';
      }
    }
    this.personInfo.nume=this.nume;
  }

  focusoutFunctionPrenume(event:any){
    this.prenume = event.target.value;
    var txt = this.prenume.split("");
    for(var i=0; i<this.prenume.length ;i++){
      if(txt[i]=='1' || txt[i]=='2' || txt[i]=='3' || txt[i]=='4' || txt[i]=='5' || txt[i]=='6' || txt[i]=='7' || txt[i]=='8' || txt[i]=='9' || txt[i]=='0'){
        this.errorMessagePrenume='Invalid field';
      }else{
        this.errorMessagePrenume='';
      }
    }
    this.personInfo.prenume=this.prenume;
  }

  focusoutFunctionOras(event:any){
    this.oras = event.target.value;
    var txt = this.oras.split("");
    for(var i=0; i<this.oras.length; i++){
      if(txt[i]=='1' || txt[i]=='2' || txt[i]=='3' || txt[i]=='4' || txt[i]=='5' || txt[i]=='6' || txt[i]=='7' || txt[i]=='8' || txt[i]=='9' || txt[i]=='0'){
        this.errorMessageOras='Invalid field';
      }else{
        this.errorMessageOras='';
      }
    }
    this.personInfo.oras=this.oras;
  }

  focusoutFunctionData(event:any){
    this.data = event.target.value;
    this.personInfo.dataNasterii=this.data;
  }


  focusoutFunctionParola(event:any){
    this.parola = event.target.value;
    if(this.parola.length<8){
      this.errorMessagePasswordLength='Va rugam introduceti o parola de minim 8 caractere';
    }else{
      this.errorMessagePasswordLength='';
    }
    this.personInfo.parola=this.parola;
  }

  focusoutFunctionConfirmare(event:any){
    this.confirmare = event.target.value;
    if(this.confirmare!=this.parola){
      this.errorMessagePassword='Parole diferite Incercati din nou';
    }
    else{
      this.errorMessagePassword='';
    }
    this.personInfo.confirmare=this.confirmare;
  }

  focusoutFunctionEmail(event:any){
    this.email = event.target.value;
    this.personInfo.email=this.email;
  }


}
