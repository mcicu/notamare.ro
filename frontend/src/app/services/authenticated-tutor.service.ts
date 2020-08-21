import {Injectable} from '@angular/core';
import {Tutor} from '../dto/tutor';
import {TutorInput} from '../dto/tutor-input';
import {HttpClient} from '@angular/common/http';
import {AuthenticationManager} from './authentication-manager.service';

@Injectable()
export class AuthenticatedTutorService {

  constructor(
    private http: HttpClient,
    private authenticationManager: AuthenticationManager) {
  }

  getTutorName(): string {
    return localStorage.getItem('name');
  }

  getTutorProfile(): Promise<Tutor> {
    return this.http.get<Tutor>('/backend/tutors/current').toPromise();
  }

  submitUpdate(id: string, tutor: TutorInput): Promise<string> {
    return new Promise<string>((resolve, reject) => {
      this.http.put('/backend/tutors/' + id, tutor).subscribe(next => {
        resolve('SAVED');
      }, reject);
    });
  }

  logout() {
    this.authenticationManager.logout();
  }
}
