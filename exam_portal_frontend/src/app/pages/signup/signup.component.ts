import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  constructor(
    private userService: UserService,
    private _snakbar: MatSnackBar
  ) {

  }

  ngOnInit(): void {
  
  }

  public user = {
    username: '',
    password: '',
    firstName: '',
    lastName: '',
    email: '',
    phone: ''
  }


  formSubmit() {
    if(this.user.username == '' || this.user.username==null) {
      this._snakbar.open("Username is required !!", "ok", {
        duration: 3000,
        verticalPosition: 'top',
        horizontalPosition: 'right'
      });
      return
    }

    // add user

    this.userService.addUser(this.user).subscribe((data) => {
      // success
      // alert("success")
    }, error => {
      // error
      console.log(error);
      this._snakbar.open("something went wrong !", 'error', {
        duration: 2000,
        panelClass:['green-snackbar', 'login-snackbar'],
        verticalPosition: 'top',
        horizontalPosition: 'right',
        
      })
    })

  }




}
