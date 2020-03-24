import {Component, OnInit} from '@angular/core';
import {TutorService} from '../services/tutor.service';
import {SessionDurationEnum, SessionPlaceEnum, StudentLevelEnum, Tutor} from '../dto/tutor';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-tutor-profile',
  templateUrl: './tutor-profile.component.html',
  styleUrls: ['./tutor-profile.component.css']
})
export class TutorProfileComponent implements OnInit {

  tutor: Tutor;
  sessionDurationEnum = SessionDurationEnum;
  sessionPlaceEnum = SessionPlaceEnum;
  studentLevelEnum = StudentLevelEnum;

  tutorProfileForm: FormGroup;

  constructor(private tutorService: TutorService) {
  }

  ngOnInit() {
    this.tutor = this.tutorService.getTutorProfile();

    this.tutorProfileForm = new FormGroup({
      name: new FormControl(this.tutor.name),
      image: new FormControl(null),
      phoneNumber: new FormControl(this.tutor.phoneNumber),
      description: new FormControl(this.tutor.description),
      location: new FormControl(this.tutor.location),
      sessionPreferences: new FormGroup({
        price: new FormControl(this.tutor.sessionPreferences.price),
        duration: new FormControl(this.tutor.sessionPreferences.duration),
        subjects: new FormControl(this.tutor.sessionPreferences.subjects),
        studentLevels: new FormControl(this.tutor.sessionPreferences.studentLevels),
        places: new FormControl(this.tutor.sessionPreferences.places)
      })
    });
  }

  onSubmit() {
    console.log(this.tutorProfileForm.value);
  }

}
