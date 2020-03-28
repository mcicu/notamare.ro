import {Mutation} from 'apollo-angular';
import {Injectable} from '@angular/core';
import gql from 'graphql-tag';

@Injectable({
  providedIn: 'root'
})
export class UpdateTutorGQL extends Mutation {

  document = gql`
    mutation updateTutor($id: String!, $tutor: TutorInput) {
      updateTutor(id: $id, tutor: $tutor) {
        id
      }
    }
  `;
}
