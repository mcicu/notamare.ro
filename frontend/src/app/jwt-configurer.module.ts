import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {JWT_OPTIONS, JwtModule} from '@auth0/angular-jwt';
import {JWTService} from './services/jwt.service';

export function jwtOptionsFactory(jwtService: JWTService) {
  return {
    tokenGetter: jwtService.getJwt
  };
}

@NgModule({
  declarations: [],
  imports: [
    HttpClientModule,
    JwtModule.forRoot({
      jwtOptionsProvider: {
        provide: JWT_OPTIONS,
        useFactory: jwtOptionsFactory,
        deps: [JWTService]
      }
    })
  ],
  providers: [JWTService]
})
export class JWTConfigurerModule {
}
