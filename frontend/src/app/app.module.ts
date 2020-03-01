import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {
  MatButtonModule,
  MatCardModule,
  MatChipsModule,
  MatGridListModule, MatIconModule,
  MatListModule, MatRippleModule, MatSelectModule,
  MatSidenavModule,
  MatSliderModule,
  MatSlideToggleModule,
  MatTabsModule,
  MatToolbarModule,
  MatInputModule, MatFormFieldModule
} from '@angular/material';
import {FlexLayoutModule} from '@angular/flex-layout';
import {TutorCardComponent} from './tutors/tutor-card/tutor-card.component';
import {TutorListService} from './services/tutor-list.service';
import {TutorsComponent} from './tutors/tutors.component';
import {TutorOverviewComponent} from './tutors/tutor-overview/tutor-overview.component';
import {TutorProfileComponent} from './tutor-profile/tutor-profile.component';
import {TutorService} from './services/tutor.service';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    TutorCardComponent,
    TutorsComponent,
    TutorOverviewComponent,
    TutorProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSliderModule, MatToolbarModule, MatSlideToggleModule, MatButtonModule, MatChipsModule, FlexLayoutModule, MatTabsModule, MatGridListModule, MatSidenavModule, MatListModule, MatCardModule, MatRippleModule, MatSelectModule, MatIconModule, MatInputModule, MatFormFieldModule
  ],
  providers: [TutorListService, TutorService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
