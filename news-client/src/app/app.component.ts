import { Component } from '@angular/core';
import { AuthenticationService } from './services/security/authentication-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private authenticaionService: AuthenticationService,
    private router: Router) { }

  isLoggedIn(): boolean {
   return this.authenticaionService.isLoggedIn();
  }

  logout(): void {
    this.authenticaionService.logout();
    this.router.navigate(['/login']);
  }
}
