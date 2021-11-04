package com.seacreeper.queen.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private MongoTemplate mongoTemplate;

  public void insertToken(@NonNull final String token) {
    mongoTemplate.insert(token, "token");
  }
}
