package pro.sky.homework27;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeNotCorrect extends RuntimeException {
    public EmployeeNotCorrect(String message) {
        super(message);
    }
}
