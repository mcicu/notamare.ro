import {Injectable} from '@angular/core';
import {Apollo} from 'apollo-angular';
import {Tutor} from '../dto/tutor';
import gql from 'graphql-tag';

@Injectable()
export class TutorProfileService {

  constructor(private apollo: Apollo) {
  }

  submitUpdate(tutor: Tutor) {
    this.apollo.mutate({
      mutation: gql(`
      mutation {
        updateTutor: (
          id = ${tutor.id}
          tutor = ${tutor}
        )
      `)
    });
    // TODO
  }
}
