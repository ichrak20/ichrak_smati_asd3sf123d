package anywr.recruitment.schoolCore.classroom.mapper;

import anywr.recruitment.school.classroom.dataobject.StudentDTO;
import anywr.recruitment.schoolCore.classroom.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter {

    private final ClassConverter classConverter;

    @Autowired
    public StudentConverter(ClassConverter classConverter) {
        this.classConverter = classConverter;
    }

    public StudentDTO toStudentDto(Student student){
        return StudentDTO.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .classDTO(classConverter.toClassDTO(student.getClassroom()))
                .build();
    }
}
