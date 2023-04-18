package pro.sky.homework27;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class EmployeesBookAlreadyAddedException extends RuntimeException{
    public EmployeesBookAlreadyAddedException(String message) {
        super(message);
    }
}
