package com.example.departmentservice.controller

import com.example.departmentservice.domain.Department
import com.example.departmentservice.logger
import com.example.departmentservice.service.DepartmentService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/departments")
class DepartmentController(
        private val departmentService: DepartmentService
) {

    private val log = logger<DepartmentService>()

    @PostMapping
    fun save(@RequestBody department: Department) : Department{
        log.info("Inside save department method of Department Controller")
        return departmentService.saveDepartment(department)
    }

    @GetMapping
    fun getAllDepartments(): List<Department>{
        log.info("Inside getAllDepartments method of Department Controller")
        return departmentService.getAllDepartments()
    }

    @GetMapping("/{id}")
    fun getDepartment(@PathVariable("id") id: UUID): Department?{
        log.info("Inside getDepartment method of Department Controller")
        return departmentService.getDepartment(id)
    }
}