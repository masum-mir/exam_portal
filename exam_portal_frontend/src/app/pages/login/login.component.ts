import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  ngOnInit(): void {
   
  }
  constructor(
    private _snakbar: MatSnackBar,
    private loginService: LoginService,
    private router: Router
  ) {

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

  formSubmit() {
    if(this.loginData.username.trim()=='' || this.loginData.username==null) {
      this._snakbar.open("Username is required !","", {
        duration: 2000,
      })
      return;
    } 
    if(this.loginData.password.trim()=='' || this.loginData.password==null) {
      this._snakbar.open("Password is required !",'', {
        duration:2000
      })
      return;
    }
    console.log(this.loginData)
    this.loginService.generatedToken(this.loginData).subscribe(
    (data:any) => {
      console.log(data)
      //login
      this.loginService.loginUser(data.token);

      this.loginService.getCurrentUser().subscribe((user:any) => {
     
        this.loginService.setUser(user);
        console.log("login user: ",user);

        // redirect .>admin : admin-dashboard
        // redirect .>normal : normal-dashboard

        if(this.loginService.getUserRole() == 'admin') {
          window.location.href='/admin';
          // this.router.navigate(['admin']);
        } else if(this.loginService.getUserRole() == 'normal') {
          window.location.href='/user-dashboard';
        } else{
          this.loginService.logout();
          // location.reload();
        }
      })
    }, (error) => {
      console.log("Error!!")
      console.log(error);
    })
  }


}
