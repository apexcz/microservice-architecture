package com.example.userservice.service

import com.example.userservice.domain.Student
import com.example.userservice.dto.Department
import com.example.userservice.dto.StudentDetailResponse
import com.example.userservice.logger
import com.example.userservice.repository.StudentRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.lang.RuntimeException
import java.util.*

@Service
class StudentService(
    private val studentRepository: StudentRepository,
    private val restTemplate: RestTemplate
) {
    private val log = logger<StudentService>()

    fun saveStudent(student: Student): Student {
        log.info("Inside saveStudent method of Student Service")
        return studentRepository.save(student)
    }

    fun getAllStudents(): List<Student> {
        log.info("Inside getAllStudents method of Student Service")
        return studentRepository.findAll()
    }

    fun getStudent(id: UUID): Student? {
        log.info("Inside getStudent method of Student Service")
        return studentRepository.findByIdOrNull(id)
    }

    fun getStudentWithDepartment(id: UUID): StudentDetailResponse? {
        log.info("Inside getStudentWithDepartment method of Student Service")
        val student = studentRepository.findByIdOrNull(id) ?: throw RuntimeException("Student not found")
        val department = restTemplate.getForObject(
            "http://DEPARTMENT-SERVICE/departments/${student.departmentId}",
            Department::class.java
        )
            ?: throw RuntimeException("Department not found")
        return StudentDetailResponse(student, department)
    }


}