// calendarmodal.component.ts
import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { SharingService } from '../services/sharing.service';
import { UserService } from '../services/user.service';
import { User } from '../model/user';

@Component({
  selector: 'app-calendarmodal',
  templateUrl: './calendarmodal.component.html',
  styleUrls: ['./calendarmodal.component.css'],
})
export class CalendarmodalComponent {
  hours: number[] = [1, 2, 3, 4, 5, 6, 7, 8];
  eventTitle: string = '';
  selectedDate: any;
  selectedPerson: any;
  selectedHour: number = 1;
  eventContainerClass: string = '';
  /* people: any[] = [
    { id: 1, name: 'Mario', surname: 'Velotto' },
    { id: 2, name: 'Francesco Pio', surname: 'Parisi' },
  ]; */
  listPerson!: User[];
  constructor(
    public dialogRef: MatDialogRef<CalendarmodalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private sharingService: SharingService,
    private userService: UserService
  ) {}

  ngOnInit(){
    this.getAllUsers()
  }

  getAllUsers(){
    this.userService.getUsers().subscribe({
      next: result => this.listPerson = result
    })
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  getEventData(): any {
    if (this.selectedPerson) {
      return {
        person: {
          id: this.selectedPerson.user_id,
          name: this.selectedPerson.firstname,
          surname: this.selectedPerson.lastname,
        },
        eventTitle: this.eventTitle,
        hour: this.selectedHour,
        eventColor: this.eventContainerClass,
      };
    }
    return null;
  }
  
}
