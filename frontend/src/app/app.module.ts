import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {FlexLayoutModule} from '@angular/flex-layout';
import {TutorCardComponent} from './tutors/tutor-card/tutor-card.component';
import {TutorListService} from './services/tutor-list.service';
import {TutorsComponent} from './tutors/tutors.component';
import {TutorOverviewComponent} from './tutors/tutor-overview/tutor-overview.component';
import {TutorProfileComponent} from './tutor-profile/tutor-profile.component';
import {GraphQLModule} from './graphql.module';
import {HttpClientModule} from '@angular/common/http';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatSelectModule} from '@angular/material/select';
import {MatIconModule} from '@angular/material/icon';
import {MatListModule} from '@angular/material/list';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatInputModule} from '@angular/material/input';
import {MatSliderModule} from '@angular/material/slider';
import {MatChipsModule} from '@angular/material/chips';
import {MatRippleModule} from '@angular/material/core';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatCardModule} from '@angular/material/card';
import {MatTabsModule} from '@angular/material/tabs';
import {MatButtonModule} from '@angular/material/button';
import {EnumToMapPipe} from './utils/enum-to-map.pipe';
import {ReactiveFormsModule} from '@angular/forms';
import {AuthenticatedTutorService} from './services/authenticated-tutor.service';
import {LoginComponent} from './authentication/login/login.component';
import {AuthenticationManager} from './services/authentication-manager.service';
import {JWTConfigurerModule} from './jwt-configurer.module';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    TutorCardComponent,
    TutorsComponent,
    TutorOverviewComponent,
    TutorProfileComponent,
    LoginComponent,
    EnumToMapPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSliderModule, MatToolbarModule, MatSlideToggleModule, MatButtonModule, MatChipsModule,
    FlexLayoutModule, MatTabsModule, MatGridListModule, MatSidenavModule, MatListModule,
    MatCardModule, MatRippleModule, MatSelectModule, MatIconModule, MatInputModule,
    MatFormFieldModule, MatCheckboxModule, GraphQLModule, HttpClientModule, ReactiveFormsModule,
    JWTConfigurerModule
  ],
  providers: [TutorListService, AuthenticatedTutorService, AuthenticationManager],
  bootstrap: [AppComponent]
})
export class AppModule {
}
