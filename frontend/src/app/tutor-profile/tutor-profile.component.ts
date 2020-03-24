import {Component, OnInit} from '@angular/core';
import {TutorService} from '../services/tutor.service';
import {SessionDurationEnum, SessionPlaceEnum, Tutor} from '../dto/tutor';

@Component({
  selector: 'app-tutor-profile',
  templateUrl: './tutor-profile.component.html',
  styleUrls: ['./tutor-profile.component.css']
})
export class TutorProfileComponent implements OnInit {

  tutor: Tutor;
  sessionDurationEnum = SessionDurationEnum;
  sessionPlaceEnum = SessionPlaceEnum;

  constructor(private tutorService: TutorService) {
  }

  ngOnInit() {
    this.tutor = this.tutorService.getTutorProfile();
  }

}
