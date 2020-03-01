import {Component, OnInit} from '@angular/core';
import {TutorService} from '../services/tutor.service';
import {Tutor} from '../dto/tutor';

@Component({
  selector: 'app-tutor-profile',
  templateUrl: './tutor-profile.component.html',
  styleUrls: ['./tutor-profile.component.css']
})
export class TutorProfileComponent implements OnInit {

  tutor: Tutor;

  constructor(private tutorService: TutorService) {
  }

  ngOnInit() {
    this.tutor = this.tutorService.getTutorProfile();
  }

}
