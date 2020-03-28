import {Injectable} from '@angular/core';
import {Tutor} from '../dto/tutor';
import {TutorsGQL} from '../graphql/tutors.query';
import {map} from 'rxjs/operators';
import {Observable} from 'rxjs';

@Injectable()
export class TutorListService {

  private readonly tutors: Observable<Tutor[]>;

  constructor(private tutorsGQL: TutorsGQL) {
    // TODO watch().valueChanges doesn't seem to work with toPromise()
    this.tutors = tutorsGQL.fetch()
      .pipe(
        map(result => result.data.tutors)
      );
  }

  getTutors(): Observable<Tutor[]> {
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
