package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Teacher;
import com.example.demo.service.TeacherService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class TeacherController {
	
	private final TeacherService service;
	
	@GetMapping("/")
	public ResponseEntity<?> getAllTeachers() {
		return ResponseEntity.ok(service.selectAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addTeacher(@Validated @RequestBody Teacher teacher) {
		service.save(teacher);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<?> editTeacher(@PathVariable Long id, @Validated @RequestBody Teacher teacher) {
		Teacher existingTeacher = service.selectByPrimaryKey(id);
		if (existingTeacher != null) {
			teacher.setId(id);
			service.save(teacher);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteTeacher(@PathVariable Long id) {
		service.deletedByPrimaryKey(id);
		return ResponseEntity.ok().build();
	}
}