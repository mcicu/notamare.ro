import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {
  MatButtonModule, MatCardModule,
  MatChipsModule,
  MatGridListModule, MatListModule, MatSidenavModule,
  MatSliderModule,
  MatSlideToggleModule,
  MatTabsModule,
  MatToolbarModule
} from '@angular/material';
import {FlexLayoutModule} from '@angular/flex-layout';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSliderModule, MatToolbarModule, MatSlideToggleModule, MatButtonModule, MatChipsModule, FlexLayoutModule, MatTabsModule, MatGridListModule, MatSidenavModule, MatListModule, MatCardModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
