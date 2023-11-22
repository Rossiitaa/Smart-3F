import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { CalendarOptions } from '@fullcalendar/core'; // useful for typechecking
import dayGridPlugin from '@fullcalendar/daygrid';
import interactionPlugin from '@fullcalendar/interaction';
import { CalendarmodalComponent } from './calendarmodal/calendarmodal.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  calendarOptions: CalendarOptions = {
    initialView: 'dayGridMonth',
    height: 'auto',
    contentHeight: 600,
    plugins: [interactionPlugin, dayGridPlugin],
    dateClick: (info) => {
      this.openModal(info);
    }
  };

  constructor(public dialog: MatDialog) {}

  openModal(info: any): void {
    const dialogRef = this.dialog.open(CalendarmodalComponent, {
      width: '500px',
      data: { date: info.dateStr },
    });

  }
}
  