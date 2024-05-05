package com.appweb.controllers;

import feign.FeignException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

//indica que esta clase manejará las excepciones para todos los controladores en mi aplicación.
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FeignException.ServiceUnavailable.class)
    @ResponseBody
    public String handleFeignServiceUnavailableException(FeignException.ServiceUnavailable ex) {
        return "El servicio de registro de usuarios no está disponible en este momento. Por favor, inténtelo de nuevo más tarde.";
    }

}