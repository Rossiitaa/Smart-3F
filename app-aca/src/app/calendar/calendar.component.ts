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

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})
export class CalendarComponent {
  calendarVisible = true;
  currentEvents: EventApi[] = [];
  selectedEvent!: any;
  events: any[] = [];
  smartUsers: any[] = [];
  absentUsers: any[] = [];
  showEvents = false
  calendarOptions: CalendarOptions = {
    initialView: 'dayGridMonth',
    height: 'auto',
    contentHeight: 600,
    weekends: false,
    selectable: true,
    selectMirror: true,
    dayMaxEvents: true,
    select: (info) => {
      this.choiceModal(info);
    },
    eventClick: this.handleEventClick.bind(this),
    eventsSet: this.handleEvents.bind(this),
    events: this.events,
    plugins: [interactionPlugin, dayGridPlugin, timeGridPlugin, listPlugin],
  };
  listPerson! : any[];
  constructor(
    public dialog: MatDialog,
    private changeDetector: ChangeDetectorRef,
    private sharingService: SharingService
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
    });

    dialogRef.afterClosed().subscribe((eventDetails: any) => {
      console.log(eventDetails)
      if (eventDetails) {
        const calendarApi = info.view.calendar;
        const eventColor = eventDetails.eventTitle === 'Smart' ? 'blue' : 'red';

        const newEvent: any = {
          id: createEventId(),
          title: eventDetails.eventTitle,
          start: info.startStr,
          end: info.endStr,
          allDay: false,
          extendedProps: {
            name: eventDetails.person.name,
            surname: eventDetails.person.surname,
          },
          backgroundColor: eventColor,
        };

        //this.events = [...this.events, newEvent];
     
        console.log(this.events.toString);
        let flag = false;
        for (const event of this.events) {
          if(event.start == newEvent.start && event.title == newEvent.title){
            
            flag = true;
          }

        }
        if(!flag){
          calendarApi.addEvent(newEvent);
          calendarApi.unselect();
          this.changeDetector.detectChanges();
        }
        this.events = [...this.events, newEvent];
        console.log(this.events);
        console.log(newEvent);
        this.sharingService.setPeople(this.events);
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
    };
  }
}
