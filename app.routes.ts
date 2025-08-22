import { Routes,RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { BookList } from './book-list/book-list';
import { Bookform } from './bookform/bookform';

export const routes: Routes = [
      { path: '', component: BookList },
      { path: 'new', component: Bookform },
      { path: 'edit/:id', component: Bookform }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}

