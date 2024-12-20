package com.diniz.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.diniz.api.dto.CourseDTO;
import com.diniz.api.dto.CoursePageDTO;
import com.diniz.domain.service.CourseService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Validated
@RestController
@RequestMapping("api/courses")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {
	
	private final CourseService courseService;
	
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@GetMapping
	public CoursePageDTO list(@RequestParam(defaultValue = "0") @PositiveOrZero int page,
			@RequestParam(defaultValue = "10") @Positive @Max(100) int pageSize) {
		return courseService.list(page, pageSize);
	}
	
	@GetMapping("/{id}")
	public CourseDTO findById(@PathVariable @NotNull @Positive Long id) {
		return courseService.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CourseDTO create(@RequestBody @Valid @NotNull CourseDTO newCourse) {
		return courseService.create(newCourse);
	}
	
	@PutMapping("/{id}")
	public CourseDTO update(@PathVariable @NotNull @Positive Long id,
			@RequestBody @Valid @NotNull CourseDTO editedCourse) {
		return courseService.update(id, editedCourse);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable @NotNull @Positive Long id) {
		courseService.delete(id);
	}
}
