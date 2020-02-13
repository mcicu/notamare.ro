import {Component} from '@angular/core';
import {TutorListService} from './services/tutor-list.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';

  constructor(private tutorListService: TutorListService) {
  }
}
