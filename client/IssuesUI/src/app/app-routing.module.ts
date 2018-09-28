import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {LoginComponent} from './login/login.component';
import {ViewIsuesComponent} from "./view-isues/view-isues.component";

const routes: Routes = [
	{path: '', component: HomeComponent},
	{path: 'login', component: LoginComponent},
	{path: 'issues', component: ViewIsuesComponent},

];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule],
})
export class AppRoutingModule {
}

// export const routedComponents = [AppRoutingComponent];
