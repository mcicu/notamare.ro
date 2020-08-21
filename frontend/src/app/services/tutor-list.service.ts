import {Injectable} from '@angular/core';
import {Tutor} from '../dto/tutor';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class TutorListService {

  private readonly tutors: Observable<Tutor[]>;

  constructor(private http: HttpClient) {
    this.tutors = this.http.get<Tutor[]>('/backend/tutors');
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
