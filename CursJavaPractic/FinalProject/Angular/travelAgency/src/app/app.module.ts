import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { TripService } from './trip.service';
import { UserService} from './user.service';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { FormsModule } from '@angular/forms';
import { LoginService} from './login.service'
import { DatePipe } from '@angular/common';
import { LoginComponent } from './login/login.component';


@NgModule({
    imports: [
        BrowserModule,
        HttpClientModule,
        AppRoutingModule,FormsModule
    ],
    declarations: [
        AppComponent,
        routingComponents,
        HeaderComponent,
        FooterComponent,
        HomeComponent,
        LoginComponent,
    ],
    providers: [TripService,UserService,LoginService, DatePipe],
    bootstrap: [AppComponent]
})
export class AppModule { }
