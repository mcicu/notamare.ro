import {Component, OnInit} from '@angular/core';
import {SessionDurationEnum, SessionPlaceEnum, StudentLevelEnum, Tutor} from '../dto/tutor';
import {FormControl, FormGroup} from '@angular/forms';
import {TutorProfileService} from '../services/tutor-profile.service';
import {TutorInput} from '../dto/TutorInput';

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
  private tutorId: string;

  constructor(private tutorProfileService: TutorProfileService) {
  }

  ngOnInit() {
    this.tutorProfileService.getTutorProfile()
      .then(value => {
        this.tutorId = value.id;
        this.tutorProfileForm = this.buildTutorProfileForm(value);
      });
  }

  onSubmit() {
    this.tutorProfileService.submitUpdate(this.tutorId, this.tutorProfileForm.value as TutorInput);
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
