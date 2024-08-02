package dzholdoshbaev.jobsearch.service;

import dzholdoshbaev.jobsearch.errors.ErrorResponseBody;
import org.springframework.validation.BindingResult;

public interface ErrorService {

    ErrorResponseBody makeResponse(Exception exception);

    ErrorResponseBody makeResponse(BindingResult bindingResult);
}
