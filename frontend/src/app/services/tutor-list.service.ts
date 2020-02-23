import {Injectable} from '@angular/core';
import {Tutor} from '../dto/tutor';

@Injectable({
  providedIn: 'root'
})
export class TutorListService {

  private tutors: Tutor[] = [
    new Tutor(
      '1-mihai-cicu',
      'Mihai Cicu',
      'https://media-exp1.licdn.com/dms/image/C5603AQHxyg5s7uYblw/profile-displayphoto-shrink_200_200/0?e=1588204800&v=beta&t=wtyDa2LNHGYkgusG_WETeftOqNSvYyegaB_U4zqFhCs', ['Computer Science'],
      {price: 100, duration: 2},
      'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages.',
      '074 444 5444',
      'Bucuresti',
      5,
      {
        studentLevels: ['Clasele I - IV', 'Clasele V - VIII', 'Liceu', 'Facultate'],
        tutoringLocations: ['Online', 'La domiciliul studentului', 'La domiciliul tutorelui']
      })
  ];

  constructor() {
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
