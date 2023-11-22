import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CalendarmodalComponent } from './calendarmodal.component';

describe('CalendarmodalComponent', () => {
  let component: CalendarmodalComponent;
  let fixture: ComponentFixture<CalendarmodalComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CalendarmodalComponent]
    });
    fixture = TestBed.createComponent(CalendarmodalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
