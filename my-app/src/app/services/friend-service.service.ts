import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/internal/observable';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class FriendServiceService {

  constructor(private httpClient:HttpClient) { }

  
  validateLogin(username, password) {
    console.log(username, password);
    return this.httpClient.get<any>('http://ec2-18-217-143-242.us-east-2.compute.amazonaws.com:8085/Snapster-P2/validateLogin') as Observable<Object[]>
    /*
    return this.httpClient.post<any>('validateLogin', { username, password })
        .pipe(map(user => {
            // store user details and jwt token in local storage to keep user logged in between page refreshes
            localStorage.setItem('currentUser', JSON.stringify(user));
           
            return user;
            
        }));
        */
        
}

/*
  validateLogin(){
    return this.httpClient.get('http://ec2-13-58-173-187.us-east-2.compute.amazonaws.com:8085/Snapster-P2/validateLogin') as Observable<Object[]>
  }
*/
}
