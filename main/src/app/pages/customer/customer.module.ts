import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule} from "@angular/router";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CustomerRoutes} from "./customer.routing";
import {SouscriptionComponent} from "./souscription/souscription.component";



@NgModule({
  declarations: [SouscriptionComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(CustomerRoutes),
    FormsModule,
    ReactiveFormsModule
  ]
})
export class CustomerModule { }
