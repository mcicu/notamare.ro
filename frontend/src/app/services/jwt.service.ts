import { Injectable } from "@angular/core";
@Injectable()
export class JWTService {

  getJwt() {
    return localStorage.getItem('jwt');
  }
}
