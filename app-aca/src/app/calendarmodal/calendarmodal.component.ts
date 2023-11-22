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
  selectedDate: Date

  constructor(
    public dialogRef: MatDialogRef<CalendarmodalComponent>,
    private elementRef: ElementRef,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {
    this.selectedDate = data.date
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

}
