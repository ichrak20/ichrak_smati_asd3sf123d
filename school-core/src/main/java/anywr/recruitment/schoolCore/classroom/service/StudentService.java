package anywr.recruitment.schoolCore.classroom.service;

import anywr.recruitment.school.classroom.dataobject.FilterDTO;
import anywr.recruitment.school.classroom.dataobject.StudentDTO;
import org.springframework.data.domain.Page;

public interface StudentService {

    Page<StudentDTO> getStudents(FilterDTO filterDTO, int page, int size);
}
