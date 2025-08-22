import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookService } from '../book.service';
import { Book } from '../book';

@Component({
  standalone: true,
  selector: 'app-book-list',
  templateUrl: './booklist.html',
  styleUrls: ['./book-list.css']
})
export class BookList implements OnInit {
  loading = false;
  books: Book[] = [];
  error = '';

  constructor(private api: BookService, private router: Router) {}

  ngOnInit(): void { this.load(); }

  load(): void {
    this.loading = true;
    this.api.getAll().subscribe({
      next: (data) => { this.books = data; this.loading = false; },
      error: (e) => { this.error = 'Failed to load'; this.loading = false; }
    });
  }

  onDelete(Bookno?: number) {
    if (!Bookno) return;
    if (!confirm('Delete this book?')) return;
    this.api.delete(Bookno).subscribe({ next: () => this.load() });
  }

  toCreate() { this.router.navigate(['/register']); }
  
toEdit(b: Book) { if (b.Bookno) this.router.navigate(['/update', b.Bookno]); 

}
}