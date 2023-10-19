package lk.ijse.finalproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TeacherDTO {
     private String id ;
     private String name;
     private String email;
     private String gender;
     private String number;
     private String subject;


}
