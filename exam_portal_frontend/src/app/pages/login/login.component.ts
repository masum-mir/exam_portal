import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  loginData = {
    username: '',
    password: ''
  }

  show_button = false;
  show_eye = false;

 showPassword() {
    this.show_button = !this.show_button;
    this.show_eye = !this.show_eye;
  }


}
