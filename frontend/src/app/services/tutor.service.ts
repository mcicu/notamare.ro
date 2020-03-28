import {Injectable} from '@angular/core';
import {TutorListService} from './tutor-list.service';
import {Tutor} from '../dto/tutor';

@Injectable()
export class TutorService {


  // TODO remove TutorListService, connect to backend
  constructor(private tutorListService: TutorListService) {
  }

  getTutorProfile(): Promise<Tutor> {
    return this.tutorListService.getTutor('5e6c9bacfaa87b0a515c56ac');
  }
}
