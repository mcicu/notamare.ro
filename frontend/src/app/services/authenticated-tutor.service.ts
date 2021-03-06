import {Injectable} from '@angular/core';
import {Tutor} from '../dto/tutor';
import {TutorInput} from '../dto/tutor-input';
import {HttpClient} from '@angular/common/http';
import {AuthenticationManager} from './authentication-manager.service';
import {map} from 'rxjs/operators';

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

  submitUpdate(tutor: TutorInput): Promise<string> {
    return new Promise<string>((resolve, reject) => {
      this.http.put('/backend/tutors/current', tutor).subscribe(next => {
        resolve('SAVED');
      }, reject);
    });
  }

  uploadProfilePicture(file: File): Promise<string> {
    const formData = new FormData();
    formData.append('file', file, file.name);
    return this.http.put('/backend/tutors/current/image', formData, {observe: 'response'})
      .pipe(map(value => value.headers.get('Location')))
      .toPromise();
  }

  logout() {
    this.authenticationManager.logout();
  }
}
