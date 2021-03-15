import { Component, OnInit } from '@angular/core';

import { BookService } from '../../../core/services/question/book.service';
import {MatTableDataSource} from '@angular/material/table';
import { Book } from './../../../core/models/book.model';

let ELEMENT_DATA: Book[] = null;

@Component({
  selector: 'app-question-list',
  templateUrl: './question-list.component.html',
  styleUrls: ['./question-list.component.scss']
})
export class QuestionListComponent implements OnInit {

  books = [];
  displayedColumns: string[] = ['id', 'title', 'anio', 'numeropaginas', 'genero', 'editorial', 'autor', 'actions'];
  dataSource = null;

  constructor(
    private questionService: BookService
  ) { }

  ngOnInit(): void {
    this.fetchBooks();
  }

  fetchBooks() {
    this.questionService.getAllBooks()
    .subscribe(books => {
      this.books = books;
      ELEMENT_DATA = books;
      this.dataSource = new MatTableDataSource(ELEMENT_DATA);
    });
  }

  deleteQuestion(id: string) {
    this.questionService.deleteBook(id)
    .subscribe(questionDeleteIsOk => {
      console.log('Question deleted rta::::', questionDeleteIsOk);
      const index = this.books.findIndex(product => product.id === id);
      this.books.splice(index, 1);
      this.books = [...this.books];
      window.confirm('Eliminado');
    });
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

}
