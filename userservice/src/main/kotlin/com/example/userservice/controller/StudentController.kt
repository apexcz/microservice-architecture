package com.example.userservice.controller

import com.example.userservice.domain.Student
import com.example.userservice.dto.StudentDetailResponse
import com.example.userservice.logger
import com.example.userservice.service.StudentService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/students")
class StudentController(
    private val studentService: StudentService
) {
    private val log = logger<StudentController>()

    @PostMapping
    fun save(@RequestBody student: Student) : Student{
        log.info("Inside save student method of Student Controller")
        return studentService.saveStudent(student)
    }

    @GetMapping
    fun getAllStudents(): List<Student>{
        log.info("Inside getAllStudents method of Student Controller")
        return studentService.getAllStudents()
    }

    @GetMapping("/{id}")
    fun getStudent(@PathVariable("id") id: UUID): Student?{
        log.info("Inside getStudent method of Student Controller")
        return studentService.getStudent(id)
    }

    @GetMapping("/{id}/dept")
    fun getStudentWithDepartment(@PathVariable("id") id: UUID): StudentDetailResponse?{
        log.info("Inside getStudentWithDepartment method of Student Controller")
        return studentService.getStudentWithDepartment(id)
    }
}