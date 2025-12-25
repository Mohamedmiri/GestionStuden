import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, CanActivateFn, GuardResult, MaybeAsync, RouterStateSnapshot } from '@angular/router';

import { AuthService } from '../services/auth.service';

import { Route, Router } from '@angular/router';

@Injectable({providedIn:'root'})
export class AuthGuard implements CanActivate{
  constructor(private authService : AuthService,
              private router : Router){

              }
  canActivate(route: ActivatedRouteSnapshot, 
    state: RouterStateSnapshot): MaybeAsync<GuardResult> {
    
      if(this.authService.isAuthenticated) {
        return true;
      }
      else{
       this.router.navigateByUrl("/login")
        return false;
      }
      }
}