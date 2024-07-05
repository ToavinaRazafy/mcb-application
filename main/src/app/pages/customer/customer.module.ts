import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule} from "@angular/router";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CustomerRoutes} from "./customer.routing";
import {SouscriptionComponent} from "./souscription/souscription.component";
import {ListComponent} from "./list/list.component";
import {AppModule} from "../../app.module";
import {CeilPipe} from "../../ceil.pipe";



@NgModule({
  declarations: [SouscriptionComponent,ListComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(CustomerRoutes),
    FormsModule,
    ReactiveFormsModule
  ]
})
export class CustomerModule { }
