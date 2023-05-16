package anywr.recruitment.schoolCore.classroom.mapper;

import anywr.recruitment.school.classroom.dataobject.ClassDTO;
import anywr.recruitment.schoolCore.classroom.entity.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassConverter {

    private final TeacherConverter teacherConverter;

    @Autowired
    public ClassConverter(TeacherConverter teacherConverter) {
        this.teacherConverter = teacherConverter;
    }


    public ClassDTO toClassDTO(Classroom classroom){
        return ClassDTO.builder().id(classroom.getId()).name(classroom.getName()).teacherDTO(teacherConverter.toTeacherDto(classroom.getTeacher())).build();
    }
}
