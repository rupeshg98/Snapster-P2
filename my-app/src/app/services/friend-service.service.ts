import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
//import {HttpHeaders} from '@angular/common/http';
import {HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs/internal/observable';
import { map } from 'rxjs/operators';
import { bindCallback } from 'rxjs';

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
  sendPhoto(username, img, message){

    console.log("Inside service sendPhoto" + username);
    console.log("Inside service img" + img.value);
    console.log("Inside service message" + message);
    // let photoData:FormData = new FormData();
    // photoData.append('file', img, img.name);
    // photoData.append('username',username,username);
    let header = new Headers();
    header.append('Content-Type','multipart/form-data');
    header.append('Accept','application/json');
    let myparams = new HttpParams().set('caption', message).set('username', username);
    return this.httpClient.post('addPhoto', img, { headers: header}) 
  }
  viewPhotos(username, includeFriends) {
    console.log(username);
    console.log(includeFriends)
    let myparams = new HttpParams().set('username', username).set('includeFriends', includeFriends);
    return this.httpClient.get('getPhotos', { params: myparams}) as Observable<Object[]>
  }
  sendPostMessage(username, message){
    console.log(username);
    console.log(message);
    let myparams = new HttpParams().set('username', username).set('post', message);
    return this.httpClient.get('addPost', { params: myparams}) as Observable<Object[]>
  }
  getPostMessages(username, includeFriends){
    console.log(username);
    console.log(includeFriends);
    let myparams = new HttpParams().set('username', username).set('includeFriends', includeFriends);
    return this.httpClient.get('getPosts', { params: myparams}) as Observable<Object[]>
  }
}
