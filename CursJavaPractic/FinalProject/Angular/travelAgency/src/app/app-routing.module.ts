import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TripComponent } from './trip/trip.component';
import { UserComponent } from './user/user.component';
import { HomeComponent} from './home/home.component';
import { LoginComponent} from './login/login.component'



const routes: Routes = [
  {path:"",redirectTo:"login",pathMatch:"full"},
  {path: 'users',component: UserComponent},
  {path: 'trips',component: TripComponent},
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export const routingComponents = [UserComponent, TripComponent,HomeComponent,LoginComponent]