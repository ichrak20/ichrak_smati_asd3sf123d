package anywr.recruitment.schoolCore.classroom.service;

import anywr.recruitment.schoolCore.classroom.dao.StudentDAO;
import anywr.recruitment.school.classroom.dataobject.FilterDTO;
import anywr.recruitment.school.classroom.dataobject.StudentDTO;
import anywr.recruitment.schoolCore.classroom.mapper.StudentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

@Service
public class StudentServiceImp implements StudentService{

    private final StudentDAO studentDAO;
    private final StudentConverter studentConverter;

    @Autowired
    public StudentServiceImp(StudentDAO studentDAO, StudentConverter studentConverter) {
        this.studentDAO = studentDAO;
        this.studentConverter = studentConverter;
    }


    @Override
    public Page<StudentDTO> getStudents(FilterDTO filterDTO, int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        if (filterDTO == null) {
            return studentDAO.findAll(pageable).map(studentConverter::toStudentDto);
        }
        if (filterDTO.getTeacherName()!=null && filterDTO.getClassName()!=null){
            return studentDAO.findByClassNameOrTeacherFullName(filterDTO.getClassName(), filterDTO.getTeacherName(), pageable)
                    .map(studentConverter::toStudentDto);
        }
        else if (filterDTO.getTeacherName()==null )
            return studentDAO.findByClassName(filterDTO.getClassName(), pageable)
                    .map(studentConverter::toStudentDto);
        else
            return studentDAO.findByTeacherFullName(filterDTO.getTeacherName(), pageable)
                    .map(studentConverter::toStudentDto);
    }
}
