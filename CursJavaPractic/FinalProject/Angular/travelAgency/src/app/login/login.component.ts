import { Component, OnInit } from '@angular/core';
import { Router, Routes } from '@angular/router';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  

  email: string;
  password: string;
  message: any

  constructor(private service: LoginService,private router:Router) { }


  ngOnInit() {
  }

  doLogin() : any{
    this.service.login(this.email, this.password).subscribe(
      data => {
      alert(data);
    },(error: any) => {
    console.log(error)
    }
    );

  }

}
