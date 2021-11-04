package com.seacreeper.queen.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import java.util.Collection;
import java.util.Collections;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;


@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

  @Value("${seacreeper.mongodb.connectio.string}")
  private String connectionString;
  @Value("${seacreeper.mongodb.username}")
  private String username;
  @Value("${seacreeper.mongodb.password}")
  private String password;


  @Value("${seacreeper.mongodb.db}")
  private String mongodbDatabase;


  @Override
  protected String getDatabaseName() {
    return mongodbDatabase;
  }

  @Override
  public MongoClient mongoClient() {
    val connectionString = new ConnectionString(this.connectionString);
    val credentials = MongoCredential
        .createCredential(username, getDatabaseName(), password.toCharArray());
    val mongoClientSettings = MongoClientSettings.builder()
        .applyConnectionString(connectionString)
        .credential(credentials)
        .build();

    return MongoClients.create(mongoClientSettings);
  }

  @Override
  public Collection getMappingBasePackages() {
    return Collections.singleton("com.seacreeper.queen");
  }
}
