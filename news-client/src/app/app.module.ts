import { HttpClient, HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { MainPageComponent } from './components/main-page/main-page.component';
import { AuthenticationService } from './services/security/authentication-service.service';
import { CanActivateAuthGuard } from './services/security/can-activate-auth.guard';
import { JwtUtilsService } from './services/security/jwt-utils.service';
import { TokenInterceptorService } from './services/security/token-interceptor.service';

import { AdminPageComponent } from './components/admin-page/admin-page.component';
import { AddEditComponent } from './components/add-edit/add-edit.component';
import { NewsService } from './services/news.service';
import { CommentService } from './services/comment.service';
import { AdPageComponent } from './components/ad-page/ad-page.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    PageNotFoundComponent,
    MainPageComponent,
    AdminPageComponent,
    AddEditComponent,
    AdPageComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptorService,
      multi: true
    },
    AuthenticationService,
    CanActivateAuthGuard,
    JwtUtilsService,
    NewsService,
    CommentService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
