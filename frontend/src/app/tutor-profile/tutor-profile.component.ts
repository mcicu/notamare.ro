import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {SessionDurationEnum, SessionPlaceEnum, StudentLevelEnum, Tutor} from '../dto/tutor';
import {FormControl, FormGroup} from '@angular/forms';
import {AuthenticatedTutorService} from '../services/authenticated-tutor.service';
import {TutorInput} from '../dto/tutor-input';
import {FormSaveStateEnum} from '../enums/form-save-state.enum';
import {StaticResourceQualifierPipe} from '../utils/static-resource-qualifier.pipe';

@Component({
  selector: 'app-tutor-profile',
  templateUrl: './tutor-profile.component.html',
  styleUrls: ['./tutor-profile.component.css']
})
export class TutorProfileComponent implements OnInit {

  @ViewChild('profileImage') profileImage: ElementRef<HTMLImageElement>;

  tutorProfileForm: FormGroup;
  tutorProfileFormSaveState = FormSaveStateEnum.SAVED;
  formSaveStateEnum = FormSaveStateEnum;
  sessionDurationEnum = SessionDurationEnum;
  sessionPlaceEnum = SessionPlaceEnum;
  studentLevelEnum = StudentLevelEnum;
  private tutorId: string;

  private staticResourceQualifierPipe = new StaticResourceQualifierPipe();

  constructor(private authenticatedTutorService: AuthenticatedTutorService) {
  }

  ngOnInit() {
    this.authenticatedTutorService.getTutorProfile()
      .then(value => {
        this.tutorId = value.id;
        this.tutorProfileForm = this.buildTutorProfileForm(value);
      });
  }

  buildTutorProfileForm(tutor: Tutor): FormGroup {
    return new FormGroup({
      name: new FormControl(tutor.name),
      image: new FormControl(tutor.image),
      phoneNumber: new FormControl(tutor.phoneNumber),
      description: new FormControl(tutor.description),
      location: new FormControl(tutor.location),
      visible: new FormControl(tutor.visible),
      sessionPreferences: new FormGroup({
        price: new FormControl(tutor.sessionPreferences.price),
        duration: new FormControl(tutor.sessionPreferences.duration),
        subjects: new FormControl(tutor.sessionPreferences.subjects.join(', ')),
        studentLevels: new FormControl(tutor.sessionPreferences.studentLevels),
        places: new FormControl(tutor.sessionPreferences.places)
      })
    });
  }

  onSubmit() {
    this.tutorProfileFormSaveState = FormSaveStateEnum.SAVING;
    const tutorInput = this.parseTutorProfileFormAndReturnTutorInput();

    this.authenticatedTutorService.submitUpdate(tutorInput).then(
      () => {
        this.tutorProfileFormSaveState = FormSaveStateEnum.JUST_SAVED;
        setTimeout(() => {
          this.resetFormSaveState();
        }, 2000);
      }
    );
  }

  onProfileImageChange(event) {
    const file: File = event.target.files[0];
    this.authenticatedTutorService.uploadProfilePicture(file)
      .then(filename => {
        this.tutorProfileForm.patchValue({image: filename});
        this.profileImage.nativeElement.src = this.staticResourceQualifierPipe.transform(filename);
      });
  }

  private resetFormSaveState() {
    if (this.tutorProfileFormSaveState === FormSaveStateEnum.JUST_SAVED) {
      this.tutorProfileFormSaveState = FormSaveStateEnum.SAVED;
    }
  }

  private parseTutorProfileFormAndReturnTutorInput(): TutorInput {
    const tutorInput = this.tutorProfileForm.value as TutorInput;
    const sessionPreferencesSubjects = this.tutorProfileForm.get('sessionPreferences.subjects').value as string;
    tutorInput.sessionPreferences.subjects = sessionPreferencesSubjects.split(/[,;]/).map(e => e.trim()).filter(e => e !== '');
    return tutorInput;
  }
}
