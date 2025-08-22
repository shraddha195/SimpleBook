import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookList } from './book-list/book-list';
import { Bookform } from './bookform/bookform';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { AppRoutingModule } from './app.routes';

const routes: Routes = [
  { path: '', component: BookList },
  { path: 'add', component: Bookform },
  { path: 'edit/:Bookno', component: Bookform }
];

@NgModule({
  declarations: [
    // Declare only non-standalone components here
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    CommonModule,
    HttpClientModule,
    AppRoutingModule,
    BookList,   // if BookList is standalone
    Bookform    // if Bookform is standalone
  ],
  bootstrap: [/* your root component here, e.g. AppComponent */]
})
export class AppModule {}
