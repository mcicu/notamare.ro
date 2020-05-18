import {Injectable} from '@angular/core';
import {Tutor} from '../dto/tutor';
import {TutorInput} from '../dto/TutorInput';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class AuthenticatedTutorService {

  constructor(private http: HttpClient) {
  }

  getTutorProfile(): Promise<Tutor> {
    return this.http.get<Tutor>('/backend/tutors/current').toPromise();
  }

  submitUpdate(id: string, tutor: TutorInput) {
    /*this.updateTutorGQL.mutate({
      id,
      tutor
    }).subscribe(value => {
      console.log('Updated ' + value);
    });*/
  }
}
