import {Component, OnInit} from '@angular/core';
import {TutorListService} from '../../services/tutor-list.service';
import {ActivatedRoute, Params} from '@angular/router';
import {SessionDurationEnum, SessionPlaceEnum, StudentLevelEnum, Tutor} from '../../dto/tutor';

@Component({
  selector: 'app-tutor-overview',
  templateUrl: './tutor-overview.component.html',
  styleUrls: ['./tutor-overview.component.css']
})
export class TutorOverviewComponent implements OnInit {

  tutor: Tutor;
  sessionDurationEnum = SessionDurationEnum;
  sessionPlaceEnum = SessionPlaceEnum;
  studentLevelEnum = StudentLevelEnum;

  constructor(private tutorListService: TutorListService, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.params.subscribe((params: Params) => {
      if (null !== params['tutor-id']) {
        this.tutorListService.getTutor(params['tutor-id']).then(value => this.tutor = value);
      } else {
        this.tutor = null;
      }
    });
  }

}
