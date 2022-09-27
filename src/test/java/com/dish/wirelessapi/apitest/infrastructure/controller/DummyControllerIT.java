package com.dish.wirelessapi.apitest.infrastructure.controller;

import com.dish.wirelessapi.apitest.domain.service.UserService;
import com.dish.wirelessapi.apitest.infrastructure.helper.UserHelper;
import com.dish.wirelessapi.apitest.infrastructure.model.DishUser;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static java.lang.Boolean.TRUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@MockBeans({
    @MockBean(UserService.class),
    @MockBean(UserHelper.class)
})
@WebMvcTest(controllers = DummyController.class)
public class DummyControllerIT {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void shouldFail_whenMissingArguments() throws Exception {
    mockMvc.perform(put("/dummy/validateFields"))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void shouldSucceedRequest() throws Exception {
    System.out.println(new Gson().toJson(buildMockFullUser()));

    mockMvc.perform(put("/dummy/validateFields")
            .content(new Gson().toJson(buildMockFullUser()))
            .contentType("application/json")
        ).andExpect(status().isOk());
  }

  private DishUser buildMockFullUser() {
    DishUser dishUser = new DishUser();
    dishUser.setActive(TRUE);
    dishUser.setFirstName("MockName");
    dishUser.setLastName("MockLastName");
    dishUser.setId("SomeId");
    dishUser.setEmail("someEmail@email.com");
    dishUser.setAge(30);

    return dishUser;
  }

}
