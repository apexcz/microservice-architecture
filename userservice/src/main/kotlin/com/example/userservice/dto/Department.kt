package com.example.userservice.dto

import java.util.*

data class Department(
    val departmentId: UUID,
    val name: String,
    val code: String,
)