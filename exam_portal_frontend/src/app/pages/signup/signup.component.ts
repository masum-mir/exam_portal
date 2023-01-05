import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss'],
  encapsulation: ViewEncapsulation.None
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

    this.userService.addUser(this.user).subscribe(
      (data: any) => {
      // success
      console.log(data);
      Swal.fire(
        'Success done!',
        'User is is' + data.id,
        'success'
      )
    }, (error) => {
      // error
      console.log(error);
      this._snakbar.open("something went wrong !", 'error', {
        duration: 2000,
        panelClass:['custom-class'],
        verticalPosition: 'top',
        horizontalPosition: 'right',
        
      })
    })

  }




}
