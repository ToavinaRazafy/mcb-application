import { Routes } from '@angular/router';


// pages
import {SouscriptionComponent} from "./souscription/souscription.component";
import {ListComponent} from "./list/list.component";
import {AuthGuard} from "../../helpers/auth.guard";

export const CustomerRoutes: Routes = [
  {
    path: '',
    children: [
      {
        path: 'souscription',
        component: SouscriptionComponent
      },
      {
        path: 'list',
        component: ListComponent,
        canActivate: [AuthGuard]
      }
    ],
  },
];
