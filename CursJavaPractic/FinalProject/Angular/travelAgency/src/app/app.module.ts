import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { TripService } from './trip.service';
import {UserService} from './user.service';
import { AccountService } from './account.service';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';


@NgModule({
    imports: [
        BrowserModule,
        HttpClientModule,
        AppRoutingModule
    ],
    declarations: [
        AppComponent,
        routingComponents,
        HeaderComponent,
        FooterComponent,
        HomeComponent
    ],
    providers: [TripService,UserService,AccountService],
    bootstrap: [AppComponent]
})
export class AppModule { }
