import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CalendarComponent } from './calendar/calendar.component';
import { DetailComponent } from './detail/detail.component';

const routes: Routes = [
  {path: 'calendar', component: CalendarComponent},
  {path: '', redirectTo: '/calendar', pathMatch: 'full'},
  {path: 'detail', component: DetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
