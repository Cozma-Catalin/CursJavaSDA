import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TripComponent } from './trip/trip.component';
import { UserComponent } from './user/user.component';
import {AccountComponent} from './account/account.component';
import {HomeComponent} from './home/home.component';



const routes: Routes = [
  {path: 'users',component: UserComponent},
  {path: 'trips',component: TripComponent},
  {path: 'accounts', component: AccountComponent},
  {path: 'home', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export const routingComponents = [UserComponent, TripComponent,AccountComponent,HomeComponent]