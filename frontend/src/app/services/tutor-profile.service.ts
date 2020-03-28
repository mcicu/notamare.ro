import {Injectable} from '@angular/core';
import {Tutor} from '../dto/tutor';
import {UpdateTutorGQL} from '../graphql/update-tutor.mutation';
import {TutorListService} from './tutor-list.service';
import {TutorInput} from '../dto/TutorInput';

@Injectable()
export class TutorProfileService {

  constructor(private tutorListService: TutorListService,
              private updateTutorGQL: UpdateTutorGQL) {
  }

  getTutorProfile(): Promise<Tutor> {
    return this.tutorListService.getTutor('5e6c9bacfaa87b0a515c56ac');
  }

  submitUpdate(id: string, tutor: TutorInput) {
    this.updateTutorGQL.mutate({
      id,
      tutor
    }).subscribe(value => {
      console.log('Updated ' + value);
    });
  }
}
