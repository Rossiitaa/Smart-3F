import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { of } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class SharingService {
  people: any[] = [];
  person: any;
  constructor() {}

  setPeople(people: any[]): void {
    this.people = people;
  }
  getPeople(): any[] {
    return this.people;
  }
}
