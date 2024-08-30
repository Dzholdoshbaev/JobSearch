package dzholdoshbaev.jobsearch.dto;

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
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotNull
    private int age;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min = 4, max = 20, message = "Length must be >= 4 and <= 20")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).+$", message = "Should contain at least one uppercase letter, one number")
    private String password;
    private String phoneNumber;
    private String avatar;
    private boolean enabled;
    private Long authorityId;
}
