import {Injectable} from '@angular/core';
import {Tutor} from '../dto/tutor';
import {TutorInput} from '../dto/tutor-input';
import {HttpClient} from '@angular/common/http';
import {AuthenticationManager} from './authentication-manager.service';
import {UpdateTutorGQL} from '../graphql/update-tutor.mutation';

@Injectable()
export class AuthenticatedTutorService {

  constructor(
    private http: HttpClient,
    private authenticationManager: AuthenticationManager,
    private updateTutorGQL: UpdateTutorGQL) {
  }

  getTutorName(): string {
    return localStorage.getItem('name');
  }

  getTutorProfile(): Promise<Tutor> {
    return this.http.get<Tutor>('/backend/tutors/current').toPromise();
  }

  submitUpdate(id: string, tutor: TutorInput): Promise<string> {
    return new Promise<string>((resolve, reject) => {
      this.updateTutorGQL.mutate({id, tutor}).subscribe(next => {
        if (next.errors == null) {
          resolve('SAVED');
        }
      }, reject);
    });
  }

  logout() {
    this.authenticationManager.logout();
  }
}
