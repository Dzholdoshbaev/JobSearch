package dzholdoshbaev.jobsearch.constant;

public enum Authority {
    APPLICANT("APPLICANT"),
    EMPLOYER("EMPLOYER");

    private final String authority;

    Authority(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }
}
