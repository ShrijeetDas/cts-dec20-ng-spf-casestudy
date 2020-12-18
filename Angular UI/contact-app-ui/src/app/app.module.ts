import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule,Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { RegisterUserComponent } from './register-user/register-user.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { FormsModule } from '@angular/forms';
import { AppFunctionsComponent } from './app-functions/app-functions.component';

let routes : Routes = [
  {path : "", component : RegisterUserComponent},
  {path : "register", component : RegisterUserComponent},
  {path : "login", component : UserLoginComponent},
  {path : "functions", component : AppFunctionsComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    RegisterUserComponent,
    UserLoginComponent,
    AppFunctionsComponent
  ],
  imports: [
    BrowserModule, FormsModule, RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
