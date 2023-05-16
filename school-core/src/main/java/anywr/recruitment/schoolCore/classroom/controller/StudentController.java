package anywr.recruitment.schoolCore.classroom.controller;

import anywr.recruitment.school.classroom.dataobject.FilterDTO;
import anywr.recruitment.school.classroom.dataobject.StudentDTO;
import anywr.recruitment.school.classroom.resource.StudentResource;
import anywr.recruitment.schoolCore.classroom.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController implements StudentResource {


    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public Page<StudentDTO> getStudent(FilterDTO filterDTO, int page, int size) {
        return studentService.getStudents(filterDTO, page, size);
    }
}
