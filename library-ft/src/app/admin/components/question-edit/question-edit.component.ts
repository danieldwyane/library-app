import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute, Params } from '@angular/router';

import { BookService } from '../../../core/services/question/book.service';

@Component({
  selector: 'app-question-edit',
  templateUrl: './question-edit.component.html',
  styleUrls: ['./question-edit.component.scss']
})
export class QuestionEditComponent implements OnInit {

  form: FormGroup;
  id: string;

  constructor(
    private formBuilder: FormBuilder,
    private questionService: BookService,
    private router: Router,
    private activateRoute: ActivatedRoute
  ) {
    this.buildForm();
  }

  ngOnInit() {
    this.activateRoute.params.subscribe((param: Params) => {
      this.id = param.id;
      this.questionService.getBook(this.id)
      .subscribe(question => {
        this.form.patchValue(question);
      });
    });
  }

  updateQuestion(event: Event) {
    event.preventDefault();
    if (this.form.valid) {
     const question = this.form.value;
     this.questionService.updateBook(question)
     .subscribe((newQuestion) => {
        console.log(newQuestion);
        this.router.navigate(['./admin/books']);
     });
    }
    console.log(this.form.value);
  }

  private buildForm() {
    this.form = this.formBuilder.group({
      id: ['', [Validators.required]],
      question: ['', [Validators.required]]
    });
  }

}
