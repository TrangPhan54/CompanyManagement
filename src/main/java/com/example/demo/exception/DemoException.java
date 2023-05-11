package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class DemoException {
    private static final String DEPARTMENT_NOT_FOUND_MSG_KEY ="DepartmentNotExisted";
    private static final String DEPARTMENT_NOT_FOUND_MSG = "Department Not Found";

    private static final String RELATIVES_NOT_FOUND_MSG_KEY = "RelativesNotExisted";
    private static final String RELATIVES_NOT_FOUND_MSG ="Relatives Not Found";

    private static final String DEPARTMENT_LOCATION_NOT_FOUND_MSG_KEY ="DepartmentLocationNotExisted";
    private static final String DEPARTMENT_LOCATION_NOT_FOUND_MSG = "Department Location Not Found";

    private static final String ASSIGNMENT_NOT_FOUND_MSG_KEY ="AssignmentNotExisted";
    private static final String ASSIGNMENT_NOT_FOUND_MSG = "Assignment Not Found";

    public static ResponseException notFound (String messageKey, String message){
        return new ResponseException(messageKey,message, HttpStatus.NOT_FOUND);
    }
    public static ResponseException badRequest (String messageKey, String message){
        return new ResponseException(messageKey, message,HttpStatus.BAD_REQUEST);
    }
    public static ResponseException internalServerError (String messageKey, String message){
        return new ResponseException(messageKey, message,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    public static ResponseException DepartmentNotFound(){
        return notFound(DEPARTMENT_NOT_FOUND_MSG_KEY,DEPARTMENT_NOT_FOUND_MSG);
    }
    public static ResponseException RelativesNotFound (){
        return notFound(RELATIVES_NOT_FOUND_MSG_KEY,RELATIVES_NOT_FOUND_MSG);
    }
    public static ResponseException DepartmentLocationNotFound (){
        return notFound(DEPARTMENT_LOCATION_NOT_FOUND_MSG_KEY,DEPARTMENT_LOCATION_NOT_FOUND_MSG);

    }
    public static ResponseException AssignmentNotFound (){
        return notFound(ASSIGNMENT_NOT_FOUND_MSG_KEY,ASSIGNMENT_NOT_FOUND_MSG);
    }
}
