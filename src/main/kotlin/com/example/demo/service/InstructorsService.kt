package com.example.demo.service

import com.example.demo.model.Courses
import com.example.demo.model.Instructors
import com.example.demo.repository.CoursesRepository
import com.example.demo.repository.InstructorsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class InstructorsService {
    @Autowired
    lateinit var instructorsRepository: InstructorsRepository

    @Autowired
    lateinit var coursesRepository: CoursesRepository

    fun list ():List<Instructors>{
        return instructorsRepository.findAll()
    }

    fun save(instructors: Instructors): Instructors {
        try{
            instructors.firstname?.takeIf{ it.trim().isNotEmpty()}
                    ?:throw  Exception("Nombres no debe ser vacio")
            return instructorsRepository.save(instructors)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.BAD_REQUEST)
        }
    }

    fun update(instructors: Instructors): Instructors{
        try {
            instructorsRepository.findById(instructors.id)
                    ?: throw Exception("ID no existe")

            return instructorsRepository.save(instructors)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(instructors: Instructors): Instructors{
        try{
            val response = instructorsRepository.findById(instructors.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                firstname=instructors.firstname
            }
            return instructorsRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun delete (id: Long?):Boolean?{
        try{
            val response = instructorsRepository.findById(id)
                    ?: throw Exception("ID no existe")
            instructorsRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById(id: Long?): Instructors? {
        return instructorsRepository.findById(id)
    }
}

