import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BannerComponent } from './components/banner/banner.component';
import { FriendsComponent } from './components/friends/friends.component';
import { LoginComponent } from './components/login/login.component';
import{UserHomeComponent} from './components/user-home/user-home.component'
const routes: Routes = [
  {
    path:"login",
    component:LoginComponent
  },
  {
    path: "banner",
    component: BannerComponent
  },
  {
    path:"friends",
    component: FriendsComponent
  },

  {
    path:"home",
    component: UserHomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
