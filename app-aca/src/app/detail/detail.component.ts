import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SharingService } from '../services/sharing.service';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  person: any;
  name: any
  surname: any

  constructor(
    private route: ActivatedRoute,
    private sharingService: SharingService
  ) {}

  ngOnInit(): void {
    this.name = this.route.snapshot.params['name']
    this.surname = this.route.snapshot.params['surname']
    
  }
}
