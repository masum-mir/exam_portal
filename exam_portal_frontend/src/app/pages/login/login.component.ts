import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
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
    private loginService: LoginService
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
    }, (error) => {
      console.log("Error!!")
      console.log(error);
    })
  }


  // login user: set token in localstroage
  public loginUser(token: string) {
    localStorage.setItem("token",token);
    return true;
  }

  // islogin: user is logged in or not

  public isLoggedIn() {
    let tokenStr = localStorage.getItem("token");
    if(tokenStr == undefined || tokenStr == '' || tokenStr == null ) {
      return false;
    } else {
      return true;
    }
  }

  // logout: remove token from local storage
  public logout() {
    localStorage.removeItem("token");
    localStorage.removeItem("user");
    return true;
  }

  //get token
  public getToken() {
    return localStorage.getItem("token");
  }

  //set userdetail

  public setUser(user:any) {
    localStorage.setItem('user', JSON.stringify(user));
  }

  // get user
  public getUser() {
    let userStr = localStorage.getItem("user");
    if(userStr != null) {
      return JSON.parse(userStr);
    } else {
      this.logout();
      return null;
    }
  }

  // get user role

  public getUserRole() {

    let user = this.getUser();
    return user.authorities[0].authority;
  }


}
