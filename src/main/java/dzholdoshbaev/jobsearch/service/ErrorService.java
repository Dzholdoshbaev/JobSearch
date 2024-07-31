package dzholdoshbaev.jobsearch.service;

import dzholdoshbaev.jobsearch.errors.ErrorResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.validation.BindingResult;

public interface ErrorService {

    ErrorResponseBody makeResponse(BindingResult bindingResult);
}
