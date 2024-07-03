import { Routes } from '@angular/router';


// pages
import {SouscriptionComponent} from "./souscription/souscription.component";

export const CustomerRoutes: Routes = [
  {
    path: '',
    children: [
      {
        path: 'souscription',
        component: SouscriptionComponent
      }
    ],
  },
];
