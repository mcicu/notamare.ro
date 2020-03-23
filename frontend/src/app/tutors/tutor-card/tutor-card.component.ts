import {Component, Input, OnInit} from '@angular/core';
import {SessionDurationEnum, Tutor} from '../../dto/tutor';

@Component({
  selector: 'app-tutor-card',
  templateUrl: './tutor-card.component.html',
  styleUrls: ['./tutor-card.component.css']
})
export class TutorCardComponent implements OnInit {

  @Input() tutor: Tutor;
  sessionDurationEnum = SessionDurationEnum;

  constructor() {
  }

  ngOnInit() {
  }

}
