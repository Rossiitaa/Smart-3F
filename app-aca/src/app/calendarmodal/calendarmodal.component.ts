// calendarmodal.component.ts
import { Component, ElementRef, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { DateSelectArg } from '@fullcalendar/core';
import { createEventId } from '../event-util';

@Component({
  selector: 'app-calendarmodal',
  templateUrl: './calendarmodal.component.html',
  styleUrls: ['./calendarmodal.component.css'],
})
export class CalendarmodalComponent {
  hours: number[] = [1, 2, 3, 4, 5, 6, 7, 8];
  eventTitle: string = '';
  selectedDate: Date;
  selectedPerson: any;
  selectedHour: number = 1;
  people: any[] = [
    { name: "Mario", surname: "Velotto" },
    { name: "Francesco Pio", surname: "Parisi" }
  ];

  constructor(
    public dialogRef: MatDialogRef<CalendarmodalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {
    this.selectedDate = data.date;
    this.selectedPerson = this.people[0]
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  getEventData(): any {
    return {
      person: {
        name: this.selectedPerson.name,
        surname: this.selectedPerson.surname
      },
      eventTitle: this.eventTitle,
      hour: this.selectedHour,
    };
  }
}
