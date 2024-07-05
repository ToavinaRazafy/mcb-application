import {
  ActivatedRouteSnapshot, CanActivate,
  CanActivateFn, GuardResult,
  MaybeAsync,
  Router,
  RouterStateSnapshot
} from '@angular/router';
import {Injectable} from "@angular/core";

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private router: Router) {

  }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const isAuthenticated = localStorage.getItem('currentUser');

    if (isAuthenticated) {
      console.log('aaaaaaa');
      return true;
    } else {
      // Utilisation de Router pour rediriger vers '/login'
      console.log('oooooo');
      this.router.navigate(['/authentication/login'], { queryParams: { returnUrl: state.url } });
      return false;
    }
  }
}
