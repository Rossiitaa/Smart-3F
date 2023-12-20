import { Component, ChangeDetectorRef } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import {
  CalendarOptions,
  EventApi,
  EventClickArg,
  EventInput,
} from '@fullcalendar/core';
import dayGridPlugin from '@fullcalendar/daygrid';
import timeGridPlugin from '@fullcalendar/timegrid';
import listPlugin from '@fullcalendar/list';
import interactionPlugin from '@fullcalendar/interaction';
import { ChoiceComponent } from '../choice/choice.component';
import { CalendarmodalComponent } from '../calendarmodal/calendarmodal.component';
import { createEventId } from '../event-util';
import { SharingService } from '../services/sharing.service';
import { Router } from '@angular/router';
import { flexibleCompare } from '@fullcalendar/core/internal';
import { UserStateService } from '../services/user-state.service';

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css'],
})
export class CalendarComponent {
  calendarVisible = true;
  currentEvents: EventApi[] = [];
  selectedEvent!: any;
  events: any[] = [];
  showEvents = false;
  selectedUser!: any;
  titleFormatted: any;
  hour: any = 0;
  calendarOptions: CalendarOptions = {
    initialView: 'dayGridMonth',
    height: 'auto',
    contentHeight: 600,
    weekends: false,
    selectable: true,
    selectMirror: false,
    dayMaxEvents: true,
    select: this.openModal.bind(this),
    eventClick: this.handleEventClick.bind(this),
    eventsSet: this.handleEvents.bind(this),
    events: this.events,
    plugins: [interactionPlugin, dayGridPlugin, timeGridPlugin, listPlugin],
  };
  listPerson!: any[];
  constructor(
    public dialog: MatDialog,
    private changeDetector: ChangeDetectorRef,
    private sharingService: SharingService,
    private router: Router,
    private usService: UserStateService
  ) {}

  choiceModal(info: any): any {
    const dialogRef = this.dialog.open(ChoiceComponent, {
      width: '300px',
    });
    dialogRef.afterClosed().subscribe((action: string) => {
      if (action === 'add') {
        this.openModal(info);
      } else if (action === 'close') {
        this.showEvents = true;
      }
    });
  }

  openModal(info: any): any {
    const dialogRef = this.dialog.open(CalendarmodalComponent, {
      width: '500px',
      data: { date: info.startStr, endDate: info.endStr  },
    });

    dialogRef.afterClosed().subscribe((eventDetails: any) => {
      if (eventDetails) {
        console.log(eventDetails.person);
        console.log(eventDetails.request);
        this.usService
          .saveUserState(
            eventDetails.person,
            eventDetails.eventTitle,
            eventDetails.request
          )
          .subscribe({
            next: () => {
              const calendarApi = info.view.calendar;
              const eventColor =
                eventDetails.eventTitle === 'ASSENZA' ? 'red' : 'blue';
              this.titleFormatted =
                eventDetails.person.name +
                ' ' +
                eventDetails.person.surname +
                ' - ' +
                eventDetails.hour +
                'h';
              const newEvent: any = {
                id: createEventId(),
                title: this.titleFormatted,
                start: info.startStr,
                end: info.endStr,
                allDay: true,
                extendedProps: {
                  id: eventDetails.person.id,
                  name: eventDetails.person.name,
                  surname: eventDetails.person.surname,
                  email: eventDetails.person.email,
                  phone: eventDetails.person.phone,
                  qualification: eventDetails.person.qualification,
                  residency: eventDetails.person.residency,
                  academyStart: eventDetails.person.academyStart,
                  academyEnd: eventDetails.person.academyEnd,
                },
                hour: eventDetails.hour,
                backgroundColor: eventColor,
              };

              let flag = false;
              if (!flag) {
                console.log(flag);
                calendarApi.addEvent(newEvent);
                //calendarApi.unselect();
                this.changeDetector.detectChanges();
              }

              this.events = [...this.events, newEvent];
              console.log(this.events);
              for (const event of this.events) {
                if (
                  event.start == newEvent.start &&
                  event.title == newEvent.title
                ) {
                  flag = true;
                }
              }

              this.sharingService.setPeople(this.events);
            },
          });
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
      surname: eventGot.event.extendedProps['surname'],
      email: eventGot.event.extendedProps['email'],
      phone: eventGot.event.extendedProps['phone'],
      qualification: eventGot.event.extendedProps['qualification'],
      residency: eventGot.event.extendedProps['residency'],
      academyStart: eventGot.event.extendedProps['academyStart'],
      academyEnd: eventGot.event.extendedProps['academyEnd'],
    };
    this.onDetailClick(this.selectedEvent);
  }

  onDetailClick(people: any) {
    this.sharingService.setPeople(people);
    this.router.navigate(['/detail']);
  }
}
