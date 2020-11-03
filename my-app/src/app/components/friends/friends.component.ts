import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-friends',
  templateUrl: './friends.component.html',
  styleUrls: ['./friends.component.css']
})
export class FriendsComponent implements OnInit {

  constructor(private friendService:FriendService) { }

  ngOnInit(): void {
  }

  requests:Object[] = []
  findAllFriendRequests(String:username){
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
