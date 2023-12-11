import { Component, OnInit } from '@angular/core';
import { TaskService } from './task.service';
import { Teacher } from './teacher.model';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';



@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})

export class AppComponent implements OnInit{
  teachers?: Teacher[];
  newTeacher: Teacher = new Teacher();

  constructor(private taskservice: TaskService) { }

  ngOnInit(): void {
    this.getTeachers();
  }

  getTeachers(): void {
    this.taskservice.getAllTeachers().subscribe(teachers => this.teachers = teachers);
  }

  addTeacher(): void {  // 引数を削除
    this.taskservice.addTeacher(this.newTeacher).subscribe(() => {
      this.getTeachers();
      this.newTeacher = new Teacher();  // フォームをリセット
    });
  }

  editTeacher(id: number, teacher: Teacher): void {
    this.taskservice.editTeacher(id, teacher).subscribe(() => this.getTeachers());
  }

  deleteTeacher(id: number): void {
    this.taskservice.deleteTeacher(id).subscribe(() => this.getTeachers());
  }

}