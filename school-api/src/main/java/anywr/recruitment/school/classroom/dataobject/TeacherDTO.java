package anywr.recruitment.school.classroom.dataobject;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TeacherDTO {
    Long id;
    String firstName;
    String lastName;
}
