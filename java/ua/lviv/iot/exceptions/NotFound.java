package ua.lviv.iot.exceptions;

import org.springframework.http.HttpStatus;

public class NotFound extends RuntimeException {

    public NotFound(HttpStatus httpStatus) {
        super(httpStatus.name());
    }

    public NotFound() {

    }
}
