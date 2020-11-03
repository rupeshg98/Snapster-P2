import { Component, OnInit } from '@angular/core';
import {FriendServiceService} from 'src/app/services/friend-service.service'
@Component({
  selector: 'app-friends',
  templateUrl: './friends.component.html',
  styleUrls: ['./friends.component.css']
})
export class FriendsComponent implements OnInit {

  constructor(private friendService:FriendServiceService) { }

  ngOnInit(): void {
  }

  requests:Object[] = []
  findAllFriendRequests(username){
    this.friendService.findAllFriendRequests(username).subscribe(
      (data) => {
        console.log(data)
        this.requests = data
      },
      () => {
        console.log("Something went wrong.")
      }
    )
  }
}
