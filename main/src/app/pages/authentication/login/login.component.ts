import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../../services/auth.service";
import {first} from "rxjs";
import {Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class AppSideLoginComponent implements OnInit {
  form: FormGroup;

  constructor(private toastr: ToastrService,private authService: AuthService, private router: Router, private fb: FormBuilder) {
    this.authService.logout();
    this.form = fb.group({
      'username': ['', Validators.required],
      'password': ['', Validators.compose([Validators.required, Validators.minLength(6)])]
    });

  }

  ngOnInit(): void {
  }

  onSubmit() {
    if (this.form.valid) {
      console.log('control');
      this.authService.login(this.form.get('username')?.value, this.form.get('password')?.value).subscribe(
          data => {
            this.router.navigate(['/customer/list']);
          },
          error => {
            console.log('error');
            this.toastr.error('Incorrect username or password', 'Authentication Error');
          });
    }
  }
}
