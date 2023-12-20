// calendarmodal.component.ts
import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { SharingService } from '../services/sharing.service';
import { UserService } from '../services/user.service';
import { User } from '../model/user';
import { StateService } from '../services/state.service';
import { State } from '../model/state';

@Component({
  selector: 'app-calendarmodal',
  templateUrl: './calendarmodal.component.html',
  styleUrls: ['./calendarmodal.component.css'],
})
export class CalendarmodalComponent {
  hours: number[] = [1, 2, 3, 4, 5, 6, 7, 8];
  eventTitle: string = '';
  selectedDate: any;
  selectedPerson: any = '';
  selectedHour: number = 1;
  eventContainerClass: string = '';
  listPerson!: User[];
  states!: any[];
  notes!: any;
  constructor(
    public dialogRef: MatDialogRef<CalendarmodalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private userService: UserService,
    private stateService: StateService
  ) {}

  ngOnInit() {
    this.getAllUsers();
    this.getAllStates();
  }

  getAllUsers() {
    this.userService.getUsers().subscribe({
      next: (result) => (this.listPerson = result),
    });
  }

  getAllStates() {
    this.stateService.getStates().subscribe({
      next: (result) => (this.states = result),
    });
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  disableHour() {}

  getEventData(): any {
    if (this.selectedPerson) {
      return {
        person: {
          id: this.selectedPerson.user_id,
          name: this.selectedPerson.firstname,
          surname: this.selectedPerson.lastname,
          email: this.selectedPerson.email,
          phone: this.selectedPerson.phoneNumber,
          qualification: this.selectedPerson.qualification,
          residency: this.selectedPerson.residency,
          academyStart: this.selectedPerson.academy_start_date,
          academyEnd: this.selectedPerson.academy_end_date,
        },
        request: {
          date: this.data.date,
          hour: this.selectedHour,
        },
        eventTitle: this.eventTitle,
        hour: this.selectedHour,
        eventColor: this.eventContainerClass,
        notes: this.notes,
      };
    }
    return null;
  }
}
