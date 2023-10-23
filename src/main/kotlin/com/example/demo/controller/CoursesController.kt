package com.example.demo.controller



import com.example.demo.model.Courses
import com.example.demo.service.CoursesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping

@RestController
@RequestMapping("/courses")
class CoursesController {
    @Autowired
    lateinit var coursesService: CoursesService

    @GetMapping
    fun list ():List <Courses>{
        return coursesService.list()
    }

    @PostMapping
    fun save (@RequestBody courses: Courses): ResponseEntity<Courses> {
        return ResponseEntity(coursesService.save(courses), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody courses: Courses): ResponseEntity<Courses> {
        return ResponseEntity(coursesService.update(courses), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody courses: Courses): ResponseEntity<Courses> {
        return ResponseEntity(coursesService.updateName(courses), HttpStatus.OK)
    }

    @DeleteMapping("/courses/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return coursesService.delete(id)
    }
}