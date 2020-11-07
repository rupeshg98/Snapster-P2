import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BannerComponent } from './components/banner/banner.component';
import { FriendsComponent } from './components/friends/friends.component';
import { LoginComponent } from './components/login/login.component';
import {UserHomeComponent} from './components/user-home/user-home.component'
import {ViewMyDetailsComponent} from './components/view-my-details/view-my-details.component'
const routes: Routes = [
  {
    path: "banner",
    component: BannerComponent
  },
  {
    path:"login",
    component:LoginComponent
  },
  {
    path:"friends",
    component: FriendsComponent
  },
  {
    path:"home",
    component: UserHomeComponent
  },
  {
    path:"viewMyDetails",
    component: ViewMyDetailsComponent
  },
  { path: '',   redirectTo: '/login', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
