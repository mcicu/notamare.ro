import {Injectable} from '@angular/core';
import {Tutor} from '../dto/tutor';
import {TutorsQuery} from '../graphql/tutors.query';
import {map} from 'rxjs/operators';
import {Observable} from 'rxjs';

@Injectable()
export class TutorListService {

  private tutors: Observable<Tutor[]>;

  constructor(private tutorsQuery: TutorsQuery) {
    this.tutors = tutorsQuery.fetch()
      .pipe(
        map(result => result.data.tutors)
      );
  }

  getTutors(): Observable<Tutor[]> {
    console.log(this.tutors);
    return this.tutors;
  }

  getTutor(tutorId: string): Promise<Tutor> {
    return this.tutors.toPromise()
      .then(tutors => {
        for (const tutor of tutors) {
          if (tutor.id === tutorId) {
            return tutor;
          }
        }
        return null;
      });
  }
}
