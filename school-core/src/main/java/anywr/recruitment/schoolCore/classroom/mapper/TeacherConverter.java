package anywr.recruitment.schoolCore.classroom.mapper;

import anywr.recruitment.school.classroom.dataobject.TeacherDTO;
import anywr.recruitment.schoolCore.classroom.entity.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherConverter {

    public TeacherDTO toTeacherDto(Teacher teacher){
        return TeacherDTO.builder().id(teacher.getId()).firstName(teacher.getFirstName()).lastName(teacher.getLastName()).build();
    }
}
