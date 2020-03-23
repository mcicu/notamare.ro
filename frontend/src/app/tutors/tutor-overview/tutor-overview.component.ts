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
      console.log(params);
      if (null !== params['tutor-id']) {
        this.tutor = this.tutorListService.getTutor(params['tutor-id']);
      } else {
        this.tutor = null;
      }
    });
  }

}
