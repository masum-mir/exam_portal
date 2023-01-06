import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) {

   }

   public generatedToken(loginData: any) {
    return this.http.post(`${baseUrl}/generate-token`,loginData);
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
    let auth = user.authorities[0].authority
    let authValue = auth.toLowerCase();
    return authValue;
  }



   // current user

   public getCurrentUser() {
    let data = this.http.get(`${baseUrl}/current-user`);

    return data;
   }

   
}
