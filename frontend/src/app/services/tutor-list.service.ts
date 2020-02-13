import {Injectable} from '@angular/core';
import {Tutor} from '../dto/tutor';

@Injectable({
  providedIn: 'root'
})
export class TutorListService {

  private tutors: Tutor[] = [
    new Tutor('Mihai C.', 'https://icons-for-free.com/iconfiles/png/512/github+network+share+social+square+icon-1320086086636119316.png',['Computer Science'], 100, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages.'),
    new Tutor('Mihai C.', 'https://icons-for-free.com/iconfiles/png/512/github+network+share+social+square+icon-1320086086636119316.png',['Computer Science'], 100, 'Teaching computer science'),
    new Tutor('Mihai C.', 'https://icons-for-free.com/iconfiles/png/512/github+network+share+social+square+icon-1320086086636119316.png',['Computer Science'], 100, 'Teaching computer science'),
  ];

  constructor() {
  }

  getTutors(): Tutor[] {
    return this.tutors.slice();
  }
}
