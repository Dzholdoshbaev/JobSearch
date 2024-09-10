package dzholdoshbaev.jobsearch.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactsInfoDto {
    private int id;
    @NotBlank(message = "You have to write your information")
    private String info;
    private int resumeId;
    @NotNull(message = "You have to choice contacts type")
    private int typeId;
}
