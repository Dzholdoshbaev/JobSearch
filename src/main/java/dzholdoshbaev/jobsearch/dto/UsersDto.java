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
public class UsersDto {
    private Long id;
    @NotBlank(message = "{resumes.createResume.should_be_not_blank}")
    private String name;
    @NotBlank(message = "{resumes.createResume.should_be_not_blank}")
    private String surname;
    @NotNull(message = "{resumes.createResume.should_be_not_blank}")
    @Min(value = 18,message = "{resumes.createResume.the_user_should_be_adult_person_older_than_17}")
    @Max(value = 70,message = "{resumes.createResume.the_user_must_be_below_retirement_age_70}")
    private Long age;
    @UniqueEmail
    @NotBlank(message = "{resumes.createResume.should_be_not_blank}")
    @Email
    private String email;
    @NotBlank(message = "{resumes.createResume.should_be_not_blank}")
    @Size(min = 4, max = 20, message = "{resumes.createResume.length_must_be_>_4_and_<_20}")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).+$", message = "{resumes.createResume.should_contain_at_least_one_uppercase_letter,_one_number}")
    private String password;
    @NotBlank(message = "{resumes.createResume.should_be_not_blank}")
    private String phoneNumber;
    private String avatar;
    private Boolean enabled;
    @NotNull(message = "{resumes.createResume.should_be_not_blank}")
    private Long authorityId;
}
