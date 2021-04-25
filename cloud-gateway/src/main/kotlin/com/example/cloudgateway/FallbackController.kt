package com.example.cloudgateway

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FallbackController {

    @GetMapping("/studentServiceFallback")
    fun studentServiceFallback() = "Student service is taking longer than expected, please try again later"

    @GetMapping("/departmentServiceFallback")
    fun departmentServiceFallback() = "Department service is taking longer than expected, please try again later"
}