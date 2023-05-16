package anywr.recruitment.school.classroom.dataobject;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClassDTO {

    Long id;
    String name;
    TeacherDTO teacherDTO;
}
