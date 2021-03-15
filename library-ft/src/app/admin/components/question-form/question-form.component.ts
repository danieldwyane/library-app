import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { BookService } from '../../../core/services/question/book.service';

@Component({
  selector: 'app-question-form',
  templateUrl: './question-form.component.html',
  styleUrls: ['./question-form.component.scss']
})
export class QuestionFormComponent implements OnInit {

  form: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private questionService: BookService,
    private router: Router,
  ) {
    this.buildForm();
  }

  ngOnInit(): void {
  }

  saveQuestion(event: Event) {
    event.preventDefault();
    if (this.form.valid) {
     const question = this.form.value;
     this.questionService.createBook(question)
     .subscribe((newQuestion) => {
        console.log(newQuestion);
        this.router.navigate(['./admin/books']);
     });
    }
    console.log(this.form.value);
  }

  private buildForm() {
    this.form = this.formBuilder.group({
      question: ['', [Validators.required]]
    });
  }

}
