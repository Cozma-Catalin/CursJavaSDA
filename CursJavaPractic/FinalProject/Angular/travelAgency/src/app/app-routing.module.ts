import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TripComponent } from './trip/trip.component';
import { UserComponent } from './user/user.component';

const routes: Routes = [
  {path: 'users',component: UserComponent},
  {path: 'trips',component: TripComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export const routingComponents = [UserComponent, TripComponent]