package dzholdoshbaev.jobsearch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Users {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String email;
    private String password;
    private String phoneNumber;
    private String avatar;
    private String accountType;
}
