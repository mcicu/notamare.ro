import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {TutorsComponent} from './tutors/tutors.component';


const routes: Routes = [
  {path: 'tutori', component: TutorsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
