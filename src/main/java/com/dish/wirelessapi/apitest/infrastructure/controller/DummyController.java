package com.dish.wirelessapi.apitest.infrastructure.controller;

import com.dish.wirelessapi.apitest.domain.service.UserService;
import com.dish.wirelessapi.apitest.infrastructure.helper.UserHelper;
import com.dish.wirelessapi.apitest.infrastructure.model.DishUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("dummy")
public class DummyController {

  private UserHelper helper;
  private UserService service;

  DummyController(UserHelper helper, UserService service) {
    this.helper = helper;
    this.service = service;
  }

  @GetMapping(value = "/get", produces = "application/json")
  public String getDummyJson() {

    System.out.println("Returning JSON");
    return """
        {
          "name":"Dummy",
          "age": 18
        }
        """;
  }

  @PutMapping(value = "/validateFields", produces = "application/JSON")
  public ResponseEntity validateFields(@Valid @RequestBody DishUser userDetails) {

    System.out.println("Received User: " + userDetails);

    service.updateUser(helper.toUser(userDetails));

    return ResponseEntity.ok().build();
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {


    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });
    return errors;
  }
}
