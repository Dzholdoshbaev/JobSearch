package dzholdoshbaev.jobsearch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactsInfo {
    private int id;
    private String info;
    private int resumeId;
    private int typeId;
}
