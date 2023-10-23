package com.example.demo.model


import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "courses")
class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null

    @Column(name = "coursesname")
    var coursesname: String? = null

    @Column(name = "department")
    var departament: String? = null

    @Column(name = "credithours")
    var credithours: Int? = null

}