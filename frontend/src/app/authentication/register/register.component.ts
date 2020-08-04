import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {AuthenticationManager} from '../../services/authentication-manager.service';
import {RegistrationOutput} from '../../dto/registration-output';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerFormGroup: FormGroup;

  constructor(
    private httpClient: HttpClient,
    private router: Router,
    private authenticationManager: AuthenticationManager) {
  }

  ngOnInit(): void {
    this.registerFormGroup = new FormGroup({
      email: new FormControl(),
      password: new FormControl()
    });
  }

  onSubmit() {
    this.httpClient.post<RegistrationOutput>(
      '/backend/register',
      this.registerFormGroup.value
    ).subscribe(
      response => {
        localStorage.setItem('jwt', response.jwt);
        localStorage.setItem('email', response.email);
        localStorage.setItem('name', response.email);
        this.authenticationManager.setAuthenticated(true);
        this.router.navigate(['profile']);
      },
      error => {
        alert('Failed to register, please retry');
      }
    );
  }
}
