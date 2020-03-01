import {Injectable} from '@angular/core';
import {TutorListService} from './tutor-list.service';
import {Tutor} from '../dto/tutor';

@Injectable()
export class TutorService {


  // TODO remove TutorListService, connect to backend
  constructor(private tutorListService: TutorListService) {
  }

  getTutorProfile(): Tutor {
    return this.tutorListService.getTutors()[0];
  }
}
