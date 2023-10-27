package com.example.demo.repository

import com.example.demo.model.Instructors
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InstructorsRepository:JpaRepository<Instructors, Long?> {

    fun findById (id: Long?):Instructors?
}