import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {FriendServiceService} from 'src/app/services/friend-service.service';
import { Router, ActivatedRoute } from '@angular/router';

import { first } from 'rxjs/operators';
@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent implements OnInit {

  constructor(private formBuilder: FormBuilder,
    private router: Router,
        ) { }

  ngOnInit(): void {
  }

}
