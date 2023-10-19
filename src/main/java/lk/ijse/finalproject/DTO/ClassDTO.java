package lk.ijse.finalproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClassDTO {
    private String classID;
    private String teacherID;
    private String subject;
    private String grade;
}
