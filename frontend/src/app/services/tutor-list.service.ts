import {Injectable} from '@angular/core';
import {Tutor} from '../dto/tutor';
import {Apollo} from 'apollo-angular';
import gql from 'graphql-tag';

@Injectable()
export class TutorListService {

  private tutors: Tutor[] = [];

  constructor(private apollo: Apollo) {
    this.apollo
    .watchQuery({
      query: gql`
        {
          tutors {
            id
            name
            phoneNumber
            description
            location
            image
            sessionPreferences {
              price
              duration
              places
              subjects
            }
          }
        }
      `,
    })
    .valueChanges.subscribe(result => {
      // @ts-ignore
      this.tutors = result.data && result.data.tutors;
      console.log(this.tutors);
    });
  }

  getTutors(): Tutor[] {
    return this.tutors.slice();
  }

  getTutor(tutorId: string): Tutor {
    for (const tutor of this.tutors) {
      if (tutorId === tutor.id) {
        return tutor;
      }
    }
    return null;
  }
}
