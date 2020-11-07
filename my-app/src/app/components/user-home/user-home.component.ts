import { Component, OnInit, ContentChildren } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {FriendServiceService} from 'src/app/services/friend-service.service';
import { Router, ActivatedRoute } from '@angular/router';
import {ViewMyDetailsComponent} from 'src/app/components/view-my-details/view-my-details.component';

import { first } from 'rxjs/operators';
@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent implements OnInit {

  @ContentChildren(ViewMyDetailsComponent)

  userHomeForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;

  constructor(
      private formBuilder: FormBuilder,
      private route: ActivatedRoute,
      private router: Router,
      private friendService: FriendServiceService
  ) {
      
  }

  ngOnInit() {
    
      this.userHomeForm = this.formBuilder.group({
          
      });
      // get return url from route parameters or default to '/'
      this.returnUrl = '/home';
      
  }
  users:Object
  // convenience getter for easy access to form fields
  get f() { return this.userHomeForm.controls; }

  viewMyInfo() {
    console.log("viewMyInfo Clicked");
    this.friendService.viewMyInfo("rupesh").subscribe(
      (data) => {
        console.log(data)
        this.users = data;
      },
      () => {
        console.log("sorry something went wrong")
      }
    )

    
  }

  viewMyPhotos(){
    console.log("viewMyPhotos Clicked");
  }

  viewMyFriends(){
    console.log("viewMyFriends Clicked");
  }  
  
  viewMyPendingFriendRequest(){
    console.log("viewMyPendingFriendRequest Clicked");
  }  
  
  addFriend(){
    console.log("addFriend Clicked");
  }  
  
  viewMyFriendPhotos(){
    console.log("viewMyPendingFriendRequest Clicked");
  }

  onSubmit() {
      this.submitted = true;

      // stop here if form is invalid
      if (this.userHomeForm.invalid) {
          return;
      }

      this.loading = true;

      console.log("Button clicked: ");
      
      //let responseData = this.friendService.validateLogin(this.f.username.value, this.f.password.value);

      //console.log("Inside logincomponentts response Data: " + responseData);
      this.router.navigate(["/home"]);

          // .pipe(first())
          // .subscribe(
          //     data => {
          //         console.log("received back: " + data);
          //         this.router.navigate(["/home"]);
          //     },
          //     error => {
                 
          //         this.loading = false;
          //     });
             
              
  }

}
