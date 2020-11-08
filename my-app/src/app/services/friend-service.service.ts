import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
//import {HttpHeaders} from '@angular/common/http';
import {HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs/internal/observable';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class FriendServiceService {

  constructor(private httpClient:HttpClient) { }

  
  validateLogin(username, password) {
    console.log(username, password);

    let myparams = new HttpParams().set('username', username).set('password', password);
  
    //return this._HttpClient.get(`${API_URL}/api/v1/data/logs`, { params: params })
    //return this.httpClient.get<any>('validateLogin', { params: myparams }) as Observable<Object[]>
    return this.httpClient.get('validateLogin', { params: myparams}) as Observable<Object[]>

    // return this.httpClient.post<any>('validateLogin', body, {headers: headers})
    //     .pipe(map(user => {
    //         // store user details and jwt token in local storage to keep user logged in between page refreshes
    //         //localStorage.setItem('currentUser', JSON.stringify(user));
    //         console.log(user);
    //         return user;
            
    //     }));
  }


  viewMyInfo(username) {
    console.log(username);

    let myparams = new HttpParams().set('username', username);
    return this.httpClient.get('viewMyInfo', { params: myparams}) as Observable<Object[]>
  }

  viewMyFriends(username) {
    console.log(username);

    let myparams = new HttpParams().set('username', username);
    return this.httpClient.get('viewMyFriends', { params: myparams}) as Observable<Object[]>
  }
  viewMyPendingFriendRequest(username){
    console.log(username);

    let myparams = new HttpParams().set('username', username);
    return this.httpClient.get('viewMyPendingFriendRequests', { params: myparams}) as Observable<Object[]>
  }

  approveFriend(username,friendusername){
    console.log(username);

    let myparams = new HttpParams().set('senderusername', friendusername).set('receiverusername', username);
    return this.httpClient.get('approveRequest', { params: myparams}) as Observable<Object[]>
  }

  unFriend(username,friendusername){
    console.log(username);

    let myparams = new HttpParams().set('senderusername', friendusername).set('receiverusername', username);
    return this.httpClient.get('unFriend', { params: myparams}) as Observable<Object[]>
  }
  requestFriend(username,friendusername){
    console.log(username);
    console.log(friendusername);

    let myparams = new HttpParams().set('senderusername', username).set('receiverusername', friendusername);
    return this.httpClient.get('addFriend', { params: myparams}) as Observable<Object[]>
  }
  viewMyPhotos(username) {
    console.log(username);

    let myparams = new HttpParams().set('username', username);
    return this.httpClient.get('getMyPhotos', { params: myparams}) as Observable<Object[]>
  }
  
}
