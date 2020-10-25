import {Component} from '@angular/core';
import {TutorListService} from '../../services/tutor-list.service';

@Component({
  selector: 'app-tutor-search',
  templateUrl: './tutor-search.component.html',
  styleUrls: ['./tutor-search.component.css']
})
export class TutorSearchComponent {

  constructor(private tutorListService: TutorListService) {
  }

  doSearch(query: string) {
    this.tutorListService.queryTutors(query);
  }
}
