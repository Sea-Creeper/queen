package com.seacreeper.queen.model;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.URL;

@Data
public class HttpRequest {
  @ApiModelProperty(notes = "Must be a String with length more than zero")
  @NonNull
  @Size(message = "Token must be a String with length more than zero", min = 1)
  String token;

  @URL(message = "URL must be valid")
  @ApiModelProperty(notes = "Must be a valid URL")
  @NonNull
  @Size(min = 1)
  String url;
}
