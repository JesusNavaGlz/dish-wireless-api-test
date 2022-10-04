package com.dish.wirelessapi.apitest.domain.service;

import com.dish.wirelessapi.apitest.domain.model.User;
import com.dish.wirelessapi.apitest.domain.repository.DatabaseRepository;
import com.dish.wirelessapi.apitest.domain.repository.ServiceProvider1;
import com.dish.wirelessapi.apitest.domain.repository.ServiceProvider2;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private DatabaseRepository databaseRepository;
  private ServiceProvider1 provider1;
  private ServiceProvider2 provider2;

  public UserService(DatabaseRepository databaseRepository, ServiceProvider1 provider1, ServiceProvider2 provider2){
    this.databaseRepository = databaseRepository;
    this.provider1 = provider1;
    this.provider2 = provider2;
  }

  //Este metodo hace algo con un usuario, hay que pasarle ble lbe ble
  //Este metodo hace algo con un usuario, hay que pasarle ble lbe ble
  //Este metodo hace algo con un usuario, hay que pasarle ble lbe ble
  //Este metodo hace algo con un usuario, hay que pasarle ble lbe ble
  //Este metodo hace algo con un usuario, hay que pasarle ble lbe ble
  //Este metodo hace algo con un usuario, hay que pasarle ble lbe ble
  //Este metodo hace algo con un usuario, hay que pasarle ble lbe ble
  //Este metodo hace algo con un usuario, hay que pasarle ble lbe ble
  //Este metodo hace algo con un usuario, hay que pasarle ble lbe ble
  //Este metodo hace algo con un usuario, hay que pasarle ble lbe ble
  public void updateUser(User user) {

    System.out.println("Starting user process to update stuff");
    System.out.println("... some complex user logic ...");
    System.out.println("... checking where to send the user ...");

    if(user.isUserActive()){
      provider1.setupUser(user);
    }else{
      provider2.setupUser(user);
    }

    System.out.println("Done running complex logics, everything is alright");
  }
}
