export class AuthenticationManager {

  private authenticated = false;

  constructor() {
    if (localStorage.getItem('jwt')) {
      this.authenticated = true;
    }
  }

  isAuthenticated(): boolean {
    return this.authenticated;
  }

  setAuthenticated(authenticated: boolean): void {
    this.authenticated = authenticated;
  }
}
