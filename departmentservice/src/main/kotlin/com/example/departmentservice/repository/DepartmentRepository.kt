package com.example.departmentservice.repository

import com.example.departmentservice.domain.Department
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface DepartmentRepository: JpaRepository<Department, UUID>