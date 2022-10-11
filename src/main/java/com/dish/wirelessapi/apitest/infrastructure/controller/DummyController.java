package com.dish.wirelessapi.apitest.infrastructure.controller;

import com.dish.wirelessapi.apitest.domain.model.BookWrapper;
import com.dish.wirelessapi.apitest.domain.repository.BookRepository;
import com.dish.wirelessapi.apitest.domain.service.UserService;
import com.dish.wirelessapi.apitest.infrastructure.model.DishUser;
import com.dish.wirelessapi.apitest.infrastructure.utils.UserDishUserMapper;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import io.swagger.v3.oas.annotations.Operation;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("dummy")
@RestControllerAdvice
public class DummyController {

  private UserDishUserMapper userMapper = Mappers.getMapper(UserDishUserMapper.class);

  private final UserService service;
  private final BookRepository repository;

  DummyController(UserService service) {
    this.service = service;
    this.repository = Feign.builder()
        .client(new OkHttpClient())
        .encoder(new GsonEncoder())
        .decoder(new GsonDecoder())
        .target(BookRepository.class, "http://localhost:3000/books");
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

  @Operation(description = "Input valid User data to be processed")
//  @ApiResponses({
//      @ApiResponse(responseCode = "200", description = "User updated successfully"),
//      @ApiResponse(responseCode = "400", description = "Missing or invalid parameters")
//  })
  @PutMapping(value = "/validateFields", produces = "application/JSON")
  public ResponseEntity validateFields(@Valid @RequestBody DishUser userDetails) {

    System.out.println("Received User: " + userDetails);

    service.updateUser(userMapper.toUser(userDetails));

    return ResponseEntity.ok().build();
  }

  @GetMapping(value = "/books/all", produces = "application/json")
  public List<BookWrapper> getAllBooks(){
    System.out.println("Retrieving all books");
    return repository.findAll();
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
