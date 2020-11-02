import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { BannerComponent } from './banner/banner.component';
import { UserHomeComponent } from './user-home/user-home.component';
import { OtherHomeComponent } from './other-home/other-home.component';
import { FriendsComponent } from './friends/friends.component';
import { SearchBarComponent } from './search-bar/search-bar.component';
import { AllPhotosComponent } from './all-photos/all-photos.component';
import { SideBarComponent } from './side-bar/side-bar.component';
import { CreateAccountComponent } from './create-account/create-account.component';


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
