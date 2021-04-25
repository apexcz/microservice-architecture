package com.example.userservice.dto

import com.example.userservice.domain.Student

data class StudentDetailResponse (
    val student: Student,
    val department: Department
    )