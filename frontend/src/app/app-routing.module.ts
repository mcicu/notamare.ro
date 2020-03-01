import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {TutorsComponent} from './tutors/tutors.component';
import {TutorOverviewComponent} from './tutors/tutor-overview/tutor-overview.component';
import {TutorProfileComponent} from './tutor-profile/tutor-profile.component';


const routes: Routes = [
  {
    path: 'tutors', component: TutorsComponent, children: [
      {path: 'overview', component: TutorOverviewComponent},
      {path: 'overview/:tutor-id', component: TutorOverviewComponent}
    ]
  },
  {
    path: 'profile', component: TutorProfileComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
