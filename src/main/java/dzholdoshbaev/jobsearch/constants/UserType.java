package dzholdoshbaev.jobsearch.constants;

import lombok.Getter;

@Getter
public enum UserType {
    APPLICANT ("APPLICANT"),
    EMPLOYER("EMPLOYER");

    private final String title;

    UserType(String title) {
        this.title = title;
    }
}
