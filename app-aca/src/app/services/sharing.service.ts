import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SharingService {
  people: any[] = [];
  
  constructor() {}

  setPeople(people: any[]): void {
    this.people = people;
  }
  getPeople(): any[] { 
    return this.people;
  }

  getPersonById(id: number){

  }

}
