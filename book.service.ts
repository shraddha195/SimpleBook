import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from './book';

@Injectable({ providedIn: 'root' })
export class BookService {
  
private baseUrl = 'http://localhost:8080/api/Book';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Book[]> {
    return this.http.get<Book[]>(this.baseUrl);
  }

  addNew(book: Book): Observable<Book> {
    return this.http.post<Book>(`${this.baseUrl}/register`, book);
  }

  getById(id: number): Observable<Book> {
    return this.http.get<Book>(`${this.baseUrl}/${id}`);
  }

  update(id: number, book: Book): Observable<Book> {
    return this.http.put<Book>(`${this.baseUrl}/update/${id}`, book);
  }

  delete(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/${id}`); // Fixed endpoint
  }
}