import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  show_button = false;
  show_eye = false;

 showPassword() {
    this.show_button = !this.show_button;
    this.show_eye = !this.show_eye;
  }

// var pwShown = 0;

// document.getElementById("eye").addEventListener("click", function () {
//   if (pwShown == 0) {
//       pwShown = 1;
//       show();
//   } else {
//       pwShown = 0;
//       hide();
//   }
// }, false);


}
