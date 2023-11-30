import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {

  person: any;

  constructor(private aRoute: ActivatedRoute){}

  ngOnInit(){
    this.person = this.aRoute.snapshot.params['id']
  }
}
