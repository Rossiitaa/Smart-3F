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
  id!: number;

  constructor(
    private sharingService: SharingService
  ) {}

  ngOnInit(): void {
    this.person = this.sharingService.getPeople()
  }
}
