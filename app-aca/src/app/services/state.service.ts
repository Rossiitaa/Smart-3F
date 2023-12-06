import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { State } from '../model/state';

@Injectable({
  providedIn: 'root'
})
export class StateService {
  url: string = 'http://localhost:8080';
  constructor(private http: HttpClient) { }

  getStates(){
    return this.http.get<State[]>(`${this.url}/getStates`)
  }

  saveState(state: State){
    return this.http.post(`${this.url}/saveState`,state)
  }

  updateState(state: State){
    return this.http.put(`${this.url}/updateState`,state.state_id)
  }

  deleteState(id: number){
    return this.http.delete(`${this.url}/deleteState/${id}`)
  }
}
