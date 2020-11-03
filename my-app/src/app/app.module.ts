import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { BannerComponent } from './components/banner/banner.component';
import { UserHomeComponent } from './components/user-home/user-home.component';
import { OtherHomeComponent } from './components/other-home/other-home.component';
import { FriendsComponent } from './components/friends/friends.component';
import { SearchBarComponent } from './components/search-bar/search-bar.component';
import { AllPhotosComponent } from './components/all-photos/all-photos.component';
import { SideBarComponent } from './components/side-bar/side-bar.component';
import { CreateAccountComponent } from './components/create-account/create-account.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    BannerComponent,
    UserHomeComponent,
    OtherHomeComponent,
    FriendsComponent,
    SearchBarComponent,
    AllPhotosComponent,
    SideBarComponent,
    CreateAccountComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent, LoginComponent]
})
export class AppModule { }
