import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {TutorsComponent} from './tutors/tutors.component';
import {TutorOverviewComponent} from './tutors/tutor-overview/tutor-overview.component';
import {TutorProfileComponent} from './tutor-profile/tutor-profile.component';
import {LoginComponent} from './authentication/login/login.component';
import {RegisterComponent} from './authentication/register/register.component';


const routes: Routes = [
  {
    path: 'tutors', component: TutorsComponent, children: [
      {path: 'overview', component: TutorOverviewComponent},
      {path: 'overview/:tutor-id', component: TutorOverviewComponent}
    ]
  },
  {path: 'register', component: RegisterComponent},
  {path: 'login', component: LoginComponent},
  {path: 'profile', component: TutorProfileComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
