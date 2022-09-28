package com.uditagarwal.cabbooking.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class PostResponse {

  public static final String OK_RESPONSE = "ok";
  public static final String ERROR_RESPONSE = "error";

  @JsonProperty private String status;
  @JsonProperty private String message;

  public PostResponse(String status, String message) {
	super();
	this.status = status;
	this.message = message;
}

public static PostResponse ok() {
    return new PostResponse(OK_RESPONSE, null);
  }

  public static PostResponse error(final String message) {
    return new PostResponse(ERROR_RESPONSE, message);
  }

public static String getOkResponse() {
	return OK_RESPONSE;
}

public static String getErrorResponse() {
	return ERROR_RESPONSE;
}

public String getStatus() {
	return status;
}

public String getMessage() {
	return message;
}
}
