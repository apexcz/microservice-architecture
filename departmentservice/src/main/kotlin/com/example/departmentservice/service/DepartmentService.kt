package com.example.departmentservice.service

import com.example.departmentservice.domain.Department
import com.example.departmentservice.logger
import com.example.departmentservice.repository.DepartmentRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class DepartmentService(
        private val departmentRepository: DepartmentRepository
){
    private val log = logger<DepartmentService>()

    fun saveDepartment(department: Department): Department{
        log.info("Inside saveDepartment method of Department Service")
        return departmentRepository.save(department)
    }

    fun getAllDepartments(): List<Department> {
        log.info("Inside getAllDepartments method of Department Service")
        return departmentRepository.findAll()
    }

    fun getDepartment(id: UUID): Department? {
        log.info("Inside getDepartment method of Department Service")
        return departmentRepository.findByIdOrNull(id)
    }
}