import {Component, OnInit} from '@angular/core';
import {TutorListService} from '../services/tutor-list.service';
import {Tutor} from '../dto/tutor';

@Component({
  selector: 'app-tutors',
  templateUrl: './tutors.component.html',
  styleUrls: ['./tutors.component.css']
})
export class TutorsComponent implements OnInit {

  private tutors: Tutor[] = [];

  constructor(private tutorListService: TutorListService) {
  }

  ngOnInit() {
    this.tutorListService.getTutors().subscribe(value => this.tutors = value);
  }
}
