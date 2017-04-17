package com.github.ququzone.basicweb.common;

import com.google.gson.JsonObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

/**
 * exception handling controller.
 *
 * @author Yang XuePing
 */
@ControllerAdvice
public class ExceptionHandlingController {
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<String> service(ServiceException ex) {
        JsonObject message = new JsonObject();
        message.addProperty("timestamp", new Date().getTime());
        message.addProperty("message", ex.getMessage());
        return ResponseEntity.status(ex.getStatusCode()).body(message.toString());
    }
}
