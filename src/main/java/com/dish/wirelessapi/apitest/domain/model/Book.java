package com.dish.wirelessapi.apitest.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Book {
  private String isbn;
  private String author;
  private String title;
  private String synopsis;
  private String language;
}
