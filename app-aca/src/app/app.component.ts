// app.component.ts
import { Component, ChangeDetectorRef } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { CalendarOptions, EventApi, EventClickArg, EventInput } from '@fullcalendar/core';
import dayGridPlugin from '@fullcalendar/daygrid';
import timeGridPlugin from '@fullcalendar/timegrid';
import listPlugin from '@fullcalendar/list';
import interactionPlugin from '@fullcalendar/interaction';
import { CalendarmodalComponent } from './calendarmodal/calendarmodal.component';
import { createEventId } from './event-util';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  calendarVisible = true;
  currentEvents: EventApi[] = [];
  selectedEvent!: any;

  calendarOptions: CalendarOptions = {
    initialView: 'dayGridMonth',
    height: 'auto',
    contentHeight: 600,
    weekends: false,
    selectable: true,
    selectMirror: true,
    dayMaxEvents: true,
    select: (info) => {
      this.openModal(info);
    },
    eventClick: this.handleEventClick.bind(this),
    eventsSet: this.handleEvents.bind(this),
    plugins: [interactionPlugin, dayGridPlugin, timeGridPlugin, listPlugin],
  };

  constructor(
    public dialog: MatDialog,
    private changeDetector: ChangeDetectorRef
  ) { }



  openModal(info: any): any {
    const dialogRef = this.dialog.open(CalendarmodalComponent, {
      width: '500px',
      data: { date: info.dateStr },
    });

    dialogRef.afterClosed().subscribe((eventDetails: any) => {
      if (eventDetails) {
        const calendarApi = info.view.calendar;
        const eventColor = eventDetails.eventTitle === 'Smart' ? 'blue' : 'red';

        const newEvent: EventInput = {
          id: createEventId(),
          title: eventDetails.eventTitle,
          start: info.startStr,
          end: info.endStr,
          allDay: info.allDay,
          extendedProps: {
            name: eventDetails.person.name,
            surname: eventDetails.person.surname,
          },
          backgroundColor: eventColor,
        };

        calendarApi.addEvent(newEvent);
        calendarApi.unselect();
      }
    });
  }

  handleEventClick(clickInfo: any) {
    this.showEventDetails(clickInfo);
  }

  handleEvents(events: EventApi[]) {
    this.currentEvents = events;
    this.changeDetector.detectChanges();
  }

  showEventDetails(eventGot: EventClickArg) {
    this.selectedEvent = {
      name: eventGot.event.extendedProps['name'],
      surname: eventGot.event.extendedProps['surname']
    };
  }

}
