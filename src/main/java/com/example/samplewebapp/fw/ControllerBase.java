package com.example.samplewebapp.fw;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindException;
import org.springframework.http.HttpStatus;
// import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.RestControllerAdvice;
// import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;

public abstract class ControllerBase {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({
    MethodArgumentNotValidException.class
  })
  public Map<String, Object> handleException(MethodArgumentNotValidException e) {
      Map<String, Object> errorMap = new HashMap<String, Object>();
    errorMap.put("data", new HashMap<String, Object>());
    List<String> errors = new ArrayList<String>();
    errors.add(e.getMessage());
    errorMap.put("errors", errors);
    return errorMap;
  }
}
