package com.example.demo.repository


import com.example.demo.model.Courses
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CoursesRepository:JpaRepository<Courses, Long?> {

    fun findById (id: Long?):Courses?

}

