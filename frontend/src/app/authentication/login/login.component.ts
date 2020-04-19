import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginFormGroup: FormGroup;

  constructor(private httpClient: HttpClient, private router: Router) {
  }

  ngOnInit(): void {
    this.loginFormGroup = new FormGroup({
      email: new FormControl(),
      password: new FormControl()
    });
  }

  onSubmit() {
    this.httpClient.post(
      '/backend/login',
      this.loginFormGroup.value,
      {responseType: 'text'}
    ).subscribe(
      response => {
        localStorage.setItem('jwt', response);
        this.router.navigate(['profile']);
      },
      error => {
        alert('Failed to login, please retry');
      }
    );
  }
}
