import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-choice',
  templateUrl: './choice.component.html',
  styleUrls: ['./choice.component.css'],
})
export class ChoiceComponent {
  constructor(public dialogRef: MatDialogRef<ChoiceComponent>) {}

  chooseOption(option: string): void {
    this.dialogRef.close(option);
  }
}
