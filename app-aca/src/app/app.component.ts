import { ChangeDetectorRef, Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import {
  CalendarOptions,
  DateSelectArg,
  EventApi,
  EventClickArg,
} from '@fullcalendar/core'; // useful for typechecking
import dayGridPlugin from '@fullcalendar/daygrid';
import timeGridPlugin from '@fullcalendar/timegrid';
import listPlugin from '@fullcalendar/list';
import interactionPlugin from '@fullcalendar/interaction';
import { CalendarmodalComponent } from './calendarmodal/calendarmodal.component';
import { INITIAL_EVENTS, createEventId } from './event-util';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  calendarVisible = true;
  calendarOptions: CalendarOptions = {
    initialView: 'dayGridMonth',
    height: 'auto',
    contentHeight: 600,
    weekends: true,
    editable: true,
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

  currentEvents: EventApi[] = [];

  constructor(
    public dialog: MatDialog,
    private changeDetector: ChangeDetectorRef
  ) {}

  openModal(info: any): any {
    const dialogRef = this.dialog.open(CalendarmodalComponent, {
      width: '500px',
      data: { date: info.dateStr },
    });

    dialogRef.afterClosed().subscribe((eventTitle: string) => {
      if (eventTitle) {
        const calendarApi = info.view.calendar;
        calendarApi.addEvent({
          id: createEventId(),
          title: eventTitle,
          start: info.startStr,
          end: info.endStr,
          allDay: info.allDay,
        });
        calendarApi.unselect();
      }
    });
  }

  handleCalendarToggle() {
    this.calendarVisible = !this.calendarVisible;
  }

  handleWeekendsToggle() {
    const { calendarOptions } = this;
    calendarOptions.weekends = !calendarOptions.weekends;
  }

  handleDateSelect(selectInfo: DateSelectArg) {
    const title = this.openModal(selectInfo);
    const calendarApi = selectInfo.view.calendar;

    calendarApi.unselect(); // clear date selection

    if (title) {
      calendarApi.addEvent({
        id: createEventId(),
        title,
        start: selectInfo.startStr,
        end: selectInfo.endStr,
        allDay: selectInfo.allDay,
      });
    }
  }

  handleEventClick(clickInfo: EventClickArg) {
    if (
      confirm(
        `Are you sure you want to delete the event '${clickInfo.event.title}'`
      )
    ) {
      clickInfo.event.remove();
    }
  }

  handleEvents(events: EventApi[]) {
    this.currentEvents = events;
    this.changeDetector.detectChanges();
  }
}
