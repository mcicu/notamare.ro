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

  tutorProfileForm: FormGroup;

  sessionDurationEnum = SessionDurationEnum;
  sessionPlaceEnum = SessionPlaceEnum;
  studentLevelEnum = StudentLevelEnum;

  constructor(private tutorService: TutorService) {
  }

  ngOnInit() {
    this.tutorService.getTutorProfile()
      .then(value => {
        this.tutorProfileForm = this.buildTutorProfileForm(value);
      });
  }

  onSubmit() {
    console.log(this.tutorProfileForm.value);
  }

  buildTutorProfileForm(tutor: Tutor): FormGroup {
    return new FormGroup({
      name: new FormControl(tutor.name),
      image: new FormControl(null),
      phoneNumber: new FormControl(tutor.phoneNumber),
      description: new FormControl(tutor.description),
      location: new FormControl(tutor.location),
      sessionPreferences: new FormGroup({
        price: new FormControl(tutor.sessionPreferences.price),
        duration: new FormControl(tutor.sessionPreferences.duration),
        subjects: new FormControl(tutor.sessionPreferences.subjects),
        studentLevels: new FormControl(tutor.sessionPreferences.studentLevels),
        places: new FormControl(tutor.sessionPreferences.places)
      })
    });
  }

}
