import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from './../material/material.module';
import { AdminRoutingModule } from './admin-routing.module';
import { NavComponent } from './components/nav/nav.component';
import { QuestionFormComponent } from './components/question-form/question-form.component';
import { QuestionListComponent } from './components/question-list/question-list.component';
import { QuestionEditComponent } from './components/question-edit/question-edit.component';

@NgModule({
  declarations: [NavComponent, QuestionFormComponent, QuestionListComponent, QuestionEditComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    ReactiveFormsModule,
    MaterialModule,
  ],
})
export class AdminModule {}
