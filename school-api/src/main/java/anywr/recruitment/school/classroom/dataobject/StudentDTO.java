package anywr.recruitment.school.classroom.dataobject;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDTO {
    Long id;
    String firstName;
    String lastName;
    ClassDTO classDTO;
}
