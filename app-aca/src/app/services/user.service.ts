import { State } from './../model/state';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  url: string = 'http://localhost:8080';
  constructor(private http: HttpClient) { }

  getUsers(){
    return this.http.get<User[]>(`${this.url}/getUsers`)
  }

  saveUser(user: User){
    return this.http.post(`${this.url}/saveUser`, user)
  }

  updateUser(user: User){
    return this.http.put(`${this.url}/updateUser`,user.user_id)
  }

  deleteUser(id:number){
    return this.http.delete(`${this.url}/deleteUser/${id}`)
  }
}
