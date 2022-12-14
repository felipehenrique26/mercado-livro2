package com.mercadolivro.mercadolivro.exception

import com.mercadolivro.mercadolivro.Response.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import java.lang.Exception

@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(NotFoundException::class)
    fun handleException(ex:NotFoundException,request:WebRequest): ResponseEntity<ErrorResponse>{
       val erro =  ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            ex.message,
        ex.errorCode,
            null
        )

        return ResponseEntity(erro, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequest(ex:BadRequestException,request:WebRequest): ResponseEntity<ErrorResponse>{
        val erro =  ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            ex.message,
            ex.errorCode,
            null
        )

        return ResponseEntity(erro, HttpStatus.BAD_REQUEST)
    }

}