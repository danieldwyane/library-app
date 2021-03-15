import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { NavComponent } from './components/nav/nav.component';
import { QuestionListComponent } from './components/question-list/question-list.component';
import { QuestionFormComponent } from './components/question-form/question-form.component';
import { QuestionEditComponent } from './components/question-edit/question-edit.component';

const routes: Routes = [
  {
    path: '',
    component: NavComponent,
    children: [
      {
        path: 'books',
        component: QuestionListComponent
      },
      {
        path: 'questions/create',
        component: QuestionFormComponent
      },
      {
        path: 'questions/edit/:id',
        component: QuestionEditComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
