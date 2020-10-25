import {Injectable} from '@angular/core';
import {Tutor} from '../dto/tutor';
import {HttpClient} from '@angular/common/http';
import {Subject} from 'rxjs';

@Injectable()
export class TutorListService {

  tutors$: Subject<Tutor[]> = new Subject<Tutor[]>();

  constructor(private http: HttpClient) {
  }

  queryTutors(query: string) {
    this.http.get<Tutor[]>('/backend/tutors', {params: {q: query}})
      .subscribe(
        value => this.tutors$.next(value),
        error => console.log(error)
      );
  }

  getTutor(tutorId: string): Promise<Tutor> {
    return this.http.get<Tutor>('/backend/tutors/' + encodeURIComponent(tutorId))
      .toPromise();
  }
}
