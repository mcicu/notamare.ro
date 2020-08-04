import { Injectable } from "@angular/core";
@Injectable()
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

  logout() {
    localStorage.clear();
    this.authenticated = false;
  }
}
