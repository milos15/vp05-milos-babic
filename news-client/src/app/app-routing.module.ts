import { AdPageComponent } from './components/ad-page/ad-page.component';
import { AdminPageComponent } from './components/admin-page/admin-page.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { LoginComponent } from './components/login/login.component';
import { MainPageComponent } from './components/main-page/main-page.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
    {path: '', component: MainPageComponent },
    // {path: '', redirectTo: 'main', pathMatch: 'full'}, // ako idemo na http://localhost:4200/ bicemo preusmereni na http://localhost:4200/main
    {path: 'ads/:id', component: AdPageComponent},
    {path: 'admin-page', component: AdminPageComponent},
    {path: 'login', component: LoginComponent},
    {path: 'login', redirectTo: 'admin-page', pathMatch: 'full'},
    {path: '**', component: PageNotFoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
