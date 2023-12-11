import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Teacher } from './teacher.model';


@Injectable({
  providedIn: 'root'
})
export class TaskService {

  private apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getAllTeachers(): Observable<Teacher[]> {
    return this.http.get<Teacher[]>(`${this.apiUrl}/`);
  }

  addTeacher(teacher: Teacher): Observable<Teacher> {
    return this.http.post<Teacher>(`${this.apiUrl}/add`, teacher);
  }

  editTeacher(id: number, teacher: Teacher): Observable<Teacher> {
    return this.http.put<Teacher>(`${this.apiUrl}/edit/${id}`, teacher);
  }

  deleteTeacher(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`);

  }
}