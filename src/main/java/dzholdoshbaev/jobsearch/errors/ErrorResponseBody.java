package dzholdoshbaev.jobsearch.errors;

import java.util.List;
import java.util.Map;

public class ErrorResponseBody {
    private String error;
    public Map<String , List<String>> reasons;
}
