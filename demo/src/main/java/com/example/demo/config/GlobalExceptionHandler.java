package com.example.demo.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<String> handleException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        
        // Set the CORS headers
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        // Return a response with the appropriate status code and error message
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        String errorMessage = "An error occurred while processing your request";
        return new ResponseEntity<>(errorMessage, status);
    }
}
