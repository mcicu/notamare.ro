import {Injectable} from '@angular/core';
import {Tutor} from '../dto/tutor';

@Injectable({
  providedIn: 'root'
})
export class TutorListService {

  private tutors: Tutor[] = [
    new Tutor('Mihai C.', ['Computer Science'], 100, 'Teaching computer science'),
    new Tutor('Mihai C.', ['Computer Science'], 100, 'Teaching computer science'),
    new Tutor('Mihai C.', ['Computer Science'], 100, 'Teaching computer science')
  ];

  constructor() {
  }

  getTutors(): Tutor[] {
    return this.tutors.slice();
  }
}
