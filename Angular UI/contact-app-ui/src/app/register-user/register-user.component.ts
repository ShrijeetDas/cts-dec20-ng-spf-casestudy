import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent {

  name : any = undefined;
  password : any = undefined;
  phoneNo : number =undefined;
  dob : Date = undefined;

  constructor(private _service : UserService ) { }

  save(formValue : any) : any {
    this._service.store(formValue);
  }

}
