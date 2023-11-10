package com.junkfoood.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ErrorException {

    private HttpStatus status;
    private String message;
}
