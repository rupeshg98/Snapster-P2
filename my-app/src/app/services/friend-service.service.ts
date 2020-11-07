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
    let responseText = this.httpClient.get('validateLogin', { params: myparams, observe: 'response'}).subscribe(
          responseData => console.log(responseData.body.toString))
    console.log("Inside service ResponseText: " + responseText);

    return responseText;

    //return this.httpClient.get<any>('validateLogin') as Observable<Object[]>
    
    // let body = {
    //   username: username,
    //   password: password
    // };

    // let headers = new HttpHeaders();
    // headers = headers.set("Content-Type", "application/x-www-form-urlencoded");


    // return this.httpClient.post('validateLogin', body, {
    //   headers: headers,
    // })
    //   .pipe(resp => {
    //       console.log("response %o, ", resp);
    //   });

    // return this.httpClient.post<any>('validateLogin', body, {headers: headers})
    //     .pipe(map(user => {
    //         // store user details and jwt token in local storage to keep user logged in between page refreshes
    //         //localStorage.setItem('currentUser', JSON.stringify(user));
    //         console.log(user);
    //         return user;
            
    //     }));
  }

/*
  validateLogin(){
    return this.httpClient.get('http://ec2-13-58-173-187.us-east-2.compute.amazonaws.com:8085/Snapster-P2/validateLogin') as Observable<Object[]>
  }
*/
}
