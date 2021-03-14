import {Component, OnInit} from '@angular/core';
import {TutorListService} from '../services/tutor-list.service';
import {Tutor} from '../dto/tutor';

@Component({
  selector: 'app-tutors',
  templateUrl: './tutors.component.html',
  styleUrls: ['./tutors.component.css']
})
export class TutorsComponent implements OnInit {

  tutors: Tutor[] = [];

  constructor(private tutorListService: TutorListService) {
    tutorListService.queryTutors('');
  }

  ngOnInit() {
    this.tutorListService.tutors$.subscribe(
      next => this.tutors = next
    );
  }
}
