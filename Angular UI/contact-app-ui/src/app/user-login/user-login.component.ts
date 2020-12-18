import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent {

  id : number = undefined;
  password : any = undefined;

  constructor(private _service : UserService) { }

  save(formValue : any) : any {
    this._service.store(formValue);
 }

}
