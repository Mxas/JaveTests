import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {LoginComponent} from './login/login.component';
import {AppRoutingModule} from './app-routing.module';
import {ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {CustomMaterialModule} from './modules/material.module';
import {HomeComponent} from './home/home.component';
import { ViewIsuesComponent } from './view-isues/view-isues.component';

@NgModule({
	declarations: [
		AppComponent,
		LoginComponent,
		HomeComponent,
		ViewIsuesComponent,
	],
	imports: [
		BrowserModule,
		AppRoutingModule,
		ReactiveFormsModule,
		HttpClientModule,
		BrowserAnimationsModule,
		CustomMaterialModule
	],
	providers: [],
	bootstrap: [AppComponent],
})
export class AppModule {
}
