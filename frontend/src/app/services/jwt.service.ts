export class JWTService {

  getJwt() {
    return localStorage.getItem('jwt');
  }
}
