package com.example.departmentservice.domain

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Department(
        @Id
        val departmentId: UUID = UUID.randomUUID(),
        val name: String,
        val code: String,
)