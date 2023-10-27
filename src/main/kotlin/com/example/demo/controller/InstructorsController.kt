package com.example.demo.controller

import com.example.demo.model.Instructors
import com.example.demo.service.InstructorsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/instructors")
class InstructorsController {

    @Autowired
    lateinit var instructorsService: InstructorsService

    @GetMapping
    fun list ():List <Instructors>{
        return instructorsService.list()
    }

    @PostMapping
    fun save (@RequestBody instructors: Instructors): ResponseEntity<Instructors> {
        return ResponseEntity(instructorsService.save(instructors), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody instructors: Instructors): ResponseEntity<Instructors> {
        return ResponseEntity(instructorsService.update(instructors), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody instructors: Instructors): ResponseEntity<Instructors> {
        return ResponseEntity(instructorsService.updateName(instructors), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return instructorsService.delete(id)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<Instructors>{
        return ResponseEntity(instructorsService.listById (id), HttpStatus.OK)

    }

}
