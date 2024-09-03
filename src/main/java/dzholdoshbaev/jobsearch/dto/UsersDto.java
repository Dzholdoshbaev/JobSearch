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
    @NotBlank(message = "Should be not blank")
    private String name;
    @NotBlank(message = "Should be not blank")
    private String surname;
    @NotNull(message = "Should be not blank")
    @Min(value = 18,message = "The user should be adult person older than 17")
    @Max(value = 70,message = "The user must be below retirement age 70")
    private Long age;
    @UniqueEmail
    @NotBlank(message = "Should be not blank")
    @Email
    private String email;
    @NotBlank(message = "Should be not blank")
    @Size(min = 4, max = 20, message = "Length must be >= 4 and <= 20")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).+$", message = "Should contain at least one uppercase letter, one number")
    private String password;
    @NotBlank(message = "Should be not blank")
    private String phoneNumber;
    private String avatar;
    private Boolean enabled;
    @NotNull(message = "Should be not blank")
    private Long authorityId;
}
