package dzholdoshbaev.jobsearch.dto;

import dzholdoshbaev.jobsearch.annotations.UniqueEmail;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoEdit {
    private Long id;
    @NotBlank(message = "{users.editUser.should_be_not_blank}")
    private String name;
    @NotBlank(message = "{users.editUser.should_be_not_blank}")
    private String surname;
    @NotNull(message = "{users.editUser.should_be_not_blank}")
    @Min(value = 18,message = "{users.editUser.the_user_should_be_adult_person_older_than_17}")
    @Max(value = 70,message = "{users.editUser.the_user_must_be_below_retirement_age_70}")
    private Long age;
    @UniqueEmail
    @NotBlank(message = "{users.editUser.should_be_not_blank}")
    @Email
    private String email;
    @NotBlank(message = "{users.editUser.should_be_not_blank}")
    @Size(min = 4, max = 20, message = "{users.editUser.length_must_be_>_4_and_<_20}")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).+$", message = "{users.editUser.should_contain_at_least_one_uppercase_letter,_one_number}")
    private String password;
    @NotBlank(message = "{users.editUser.should_be_not_blank}")
    private String phoneNumber;
    private String avatar;
    private Boolean enabled;
    private Long authorityId;
}
