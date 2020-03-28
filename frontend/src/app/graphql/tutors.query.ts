import gql from 'graphql-tag';
import {Tutor} from '../dto/tutor';
import {Injectable} from '@angular/core';
import {Query} from 'apollo-angular';

interface Response {
  tutors: Tutor[];
}

@Injectable({
  providedIn: 'root',
})
export class TutorsQuery extends Query<Response> {
  document = gql`
    query tutors {
      tutors {
        id
        name
        image
        phoneNumber
        description
        location
        sessionPreferences {
          price
          duration
          subjects
          studentLevels
          places
        }
      }
    }`;
}

