import {Component, OnInit} from '@angular/core';
import {AuthenticationManager} from '../services/authentication-manager.service';
import {AuthenticatedTutorService} from '../services/authenticated-tutor.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  constructor(
    private authenticationManager: AuthenticationManager,
    private authenticatedTutorService: AuthenticatedTutorService) {
  }

  ngOnInit() {
  }
}
