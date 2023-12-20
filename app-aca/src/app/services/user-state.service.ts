import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class UserStateService {
  url: string = 'http://localhost:8080';
  constructor(private http: HttpClient) { }

  saveUserState(user: any, state: any, request: any ){
    console.log(user.id)
    return this.http.post(`${this.url}/saveUserState/${user.id}/${state.state_id}`,request)
  }
}