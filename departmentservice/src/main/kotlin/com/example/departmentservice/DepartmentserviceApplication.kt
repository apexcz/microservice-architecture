package com.example.departmentservice

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class DepartmentserviceApplication

fun main(args: Array<String>) {
	runApplication<DepartmentserviceApplication>(*args)
}

inline fun <reified T> logger(): Logger{
	return LoggerFactory.getLogger(T::class.java)
}
