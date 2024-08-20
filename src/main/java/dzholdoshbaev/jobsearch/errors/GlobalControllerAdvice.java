package dzholdoshbaev.jobsearch.errors;

import dzholdoshbaev.jobsearch.service.ErrorService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalControllerAdvice {
    private final ErrorService errorService;


//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<ErrorResponseBody> handleNoSuchElementException(NoSuchElementException e) {
//        return new ResponseEntity<>(errorService.makeResponse(e),HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ErrorResponseBody> validationHandler(MethodArgumentNotValidException e) {
//        return new ResponseEntity<>(errorService.makeResponse(e.getBindingResult()),HttpStatus.BAD_REQUEST);
//    }


    @ExceptionHandler(NoSuchElementException.class)
    public String notFound(HttpServletRequest request, Model model) {
        model.addAttribute("status", HttpStatus.NOT_FOUND.value());
        model.addAttribute("reason", HttpStatus.NOT_FOUND.getReasonPhrase());
        model.addAttribute("details", request);
        return "errors/error";
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String validationHandler(HttpServletRequest request,  Model model) {
        model.addAttribute("status", HttpStatus.BAD_REQUEST.value());
        model.addAttribute("reason", HttpStatus.BAD_REQUEST.getReasonPhrase());
        model.addAttribute("details" , request);
        return "errors/error";
    }
}
