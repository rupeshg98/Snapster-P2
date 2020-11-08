import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import {FriendServiceService} from 'src/app/services/friend-service.service';


@Component(

  { templateUrl: 'login.component.html'})
export class LoginComponent implements OnInit {

    loginForm: FormGroup;
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
      
        this.loginForm = this.formBuilder.group({
            username: ['', Validators.required],
            password: ['', Validators.required]
        });
        // get return url from route parameters or default to '/'
        this.returnUrl = '/home';
        
    }

    // convenience getter for easy access to form fields
    get f() { return this.loginForm.controls; }

    onSubmit() {
        this.submitted = true;

        // stop here if form is invalid
        if (this.loginForm.invalid) {
            return;
        }

        this.loading = true;
        
        this.friendService.validateLogin(this.f.username.value, this.f.password.value).subscribe(
            (data) => {
                console.log("Received validateLogin response: " + data);
                if (data == null) {
                    alert("Invalid credentials!");
                    this.router.navigate(["/login"]);
                }
                else {
                    console.log("Values: " + data["username"]);
                    //localStorage.setItem('currentUser', JSON.stringify(data["username"]));
                    localStorage.setItem('currentUser', data["username"]);
                    this.router.navigate(["/home"]);
                }
            },
            () => {
              console.log("sorry something went wrong")
              this.router.navigate(["/login"]);
            }
          )
                
    }
    
}
