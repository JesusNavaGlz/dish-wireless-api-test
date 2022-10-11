package com.dish.wirelessapi.apitest.domain.repository;


import com.dish.wirelessapi.apitest.domain.model.BookWrapper;
import feign.RequestLine;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository {

  @RequestLine("GET")
  List<BookWrapper> findAll();

}
