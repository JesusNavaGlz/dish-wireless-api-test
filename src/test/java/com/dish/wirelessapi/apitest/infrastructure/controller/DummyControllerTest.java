package com.dish.wirelessapi.apitest.infrastructure.controller;

import com.dish.wirelessapi.apitest.domain.service.UserService;
import com.dish.wirelessapi.apitest.infrastructure.helper.UserHelper;
import com.dish.wirelessapi.apitest.infrastructure.model.DishUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.lang.Boolean.TRUE;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DummyControllerTest {

  @Mock
  private UserService service;
  @Mock
  private UserHelper helper;

  @Mock
  private DishUser dishUser;

  @InjectMocks
  private DummyController controller;

  @BeforeEach
  public void init() {
  }


  @Test
  public void shouldFail_whenMissingField() {

    controller.validateFields(dishUser);

    verify(helper, times(1)).toUser(any());
    verify(service, times(1)).updateUser(any());

  }

  /*
  Esta prueba valida que bla bla bla
  necesita bla bla entradas
  y valida bla bla bla
   */
  @Test//Clean Code -> Codigo Legible
  public void testSomething() {
    // Inicializar
    System.out.println("Inicializa variable A");
    System.out.println("Inicializa variable B");
    System.out.println("Inicializa variable C");
    System.out.println("Suma A y B");

    // Procesar / ejecutar
    System.out.println("Procesa A");
    System.out.println("Procesa A+B");
    System.out.println("Procesa C");

    // Validar
    System.out.println("Valida A");
    System.out.println("Valida C");
  }

  private DishUser buildMockFullUser() {
    DishUser dishUser = new DishUser();
    dishUser.setActive(TRUE);
    dishUser.setFirstName("MockName");
    dishUser.setLastName("MockLastName");
    dishUser.setId("SomeId");

    return dishUser;
  }

}