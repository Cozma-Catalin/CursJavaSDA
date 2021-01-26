import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { TripService } from './trip.service';
import {UserService} from './user.service';

@NgModule({
    imports: [
        BrowserModule,
        HttpClientModule,
        AppRoutingModule
    ],
    declarations: [
        AppComponent,
        routingComponents
    ],
    providers: [TripService,UserService],
    bootstrap: [AppComponent]
})
export class AppModule { }
