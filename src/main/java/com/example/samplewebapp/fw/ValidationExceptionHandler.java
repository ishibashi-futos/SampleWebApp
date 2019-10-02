package com.example.samplewebapp.fw;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import org.springframework.validation.BindException;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationExceptionHandler {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({
    ConstraintViolationException.class, // パスパラメータまたは引数で指定するケース
    InvalidDefinitionException.class, // JacksonがEnumをBindするときに失敗すると出る
    BindException.class, // 引数でDTOを指定するケース
    IllegalArgumentException.class, // 独自バリデータが投げる例外
    BindException.class // 引数で@RequestBodyを指定するケース
  })
  public Map<String, Object> handleBindingException(Exception e, WebRequest request) {
      Map<String, Object> errorMap = new HashMap<String, Object>();
    errorMap.put("data", new HashMap<String, Object>());
    List<String> errors = new ArrayList<String>();
    errors.add(e.getMessage());
    errorMap.put("errors", errors);
    return errorMap;
  }
}