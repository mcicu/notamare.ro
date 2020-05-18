import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {AuthenticationManager} from '../../services/authentication-manager.service';
import {AuthenticationOutput} from '../../dto/authentication-output';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginFormGroup: FormGroup;

  constructor(
    private httpClient: HttpClient,
    private router: Router,
    private authenticationManager: AuthenticationManager) {
  }

  ngOnInit(): void {
    this.loginFormGroup = new FormGroup({
      email: new FormControl(),
      password: new FormControl()
    });
  }

  onSubmit() {
    this.httpClient.post<AuthenticationOutput>(
      '/backend/login',
      this.loginFormGroup.value
    ).subscribe(
      response => {
        localStorage.setItem('jwt', response.jwt);
        localStorage.setItem('email', response.email);
        localStorage.setItem('name', response.name);
        this.authenticationManager.setAuthenticated(true);
        this.router.navigate(['profile']);
      },
      error => {
        alert('Failed to login, please retry');
      }
    );
  }
}
