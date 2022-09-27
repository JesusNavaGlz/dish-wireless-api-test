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
import org.springframework.boot.test.mock.mockito.MockBean;

import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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

  private DishUser buildMockFullUser() {
    DishUser dishUser = new DishUser();
    dishUser.setActive(TRUE);
    dishUser.setFirstName("MockName");
    dishUser.setLastName("MockLastName");
    dishUser.setId("SomeId");

    return dishUser;
  }

}