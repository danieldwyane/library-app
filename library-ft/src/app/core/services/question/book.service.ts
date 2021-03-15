import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../../environments/environment';
import { Question } from '../../models/question.model';
import { Book } from '../../models/book.model';

@Injectable({
  providedIn: 'root',
})
export class BookService {
  constructor(private http: HttpClient) {}

  getAllBooks() {
    return this.http.get<Book[]>(`${environment.url_api}/book/`);
  }

  getBook(id: string) {
    return this.http.get<Book[]>(`${environment.url_api}/book/${id}`);
  }

  createBook(question: Book) {
    return this.http.post(`${environment.url_api}/book/`, question);
  }

  updateBook(changes: Partial<Book>) {
    return this.http.put(`${environment.url_api}/book/`, changes);
  }

  deleteBook(id: string) {
    return this.http.delete(`${environment.url_api}/book/${id}`);
  }
}
