import {Component, OnInit} from '@angular/core';
import {TutorListService} from '../services/tutor-list.service';

@Component({
  selector: 'app-tutors',
  templateUrl: './tutors.component.html',
  styleUrls: ['./tutors.component.css']
})
export class TutorsComponent implements OnInit {

  constructor(private tutorListService: TutorListService) {
  }

  ngOnInit() {
  }

}
