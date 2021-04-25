package com.example.userservice.domain

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Student(
    @Id
    val studentId: UUID = UUID.randomUUID(),
    val name: String,
    val email: String,
    val departmentId: UUID
)