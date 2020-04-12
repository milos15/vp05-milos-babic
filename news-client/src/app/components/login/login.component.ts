import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/security/authentication-service.service';
import {Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public user;
  public wrongUserNameOrPass: boolean;

  constructor(private authenticationService: AuthenticationService,
    private router: Router) { 
      this.user = {};
      this.wrongUserNameOrPass = false;
    }

  ngOnInit() {
  }

  login() : void {
    this.authenticationService.login(this.user.username, this.user.password)
      .subscribe(( isLoggedIn: boolean) => {
        if(isLoggedIn) {
          this.router.navigate(["/admin-page"]);
        }
      })
  }
}
