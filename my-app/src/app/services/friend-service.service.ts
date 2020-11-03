import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import {Observable} from 'rxjs/internal/observable'

@Injectable({
  providedIn: 'root'
})
export class FriendServiceService {

  constructor(private httpClient:HttpClient) { }

  findAllFriendRequests(username){
    return this.httpClient.get('http://localhost:8087/monstercard/ ') as Observable<Object[]>
  }
}
