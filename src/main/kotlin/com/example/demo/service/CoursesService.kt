package com.example.demo.service

import com.example.demo.model.Courses
import com.example.demo.repository.CoursesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class CoursesService {
    @Autowired
    lateinit var coursesRepository: CoursesRepository

    fun list ():List<Courses>{
        return coursesRepository.findAll()
    }

    fun save(courses: Courses): Courses {
        try{
            return coursesRepository.save(courses)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun update(courses: Courses): Courses{
        try {
            coursesRepository.findById(courses.id)
                ?: throw Exception("ID no existe")

            return coursesRepository.save(courses)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(courses: Courses): Courses{
        try{
            val response = coursesRepository.findById(courses.id)
                ?: throw Exception("ID no existe")
            response.apply {
                credithours=courses.credithours
            }
            return coursesRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun delete (id: Long?):Boolean?{
        try{
            val response = coursesRepository.findById(id)
                ?: throw Exception("ID no existe")
            coursesRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById(id: Long?): Courses? {
        return coursesRepository.findById(id)
    }
    }

