package anywr.recruitment.school.classroom.resource;

import anywr.recruitment.school.classroom.dataobject.FilterDTO;
import anywr.recruitment.school.classroom.dataobject.StudentDTO;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/api")
public interface StudentResource {

    @PostMapping("/students")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    Page<StudentDTO> getStudent(@RequestBody (required=false) FilterDTO filterDTO, @RequestParam("page") int page,
                                @RequestParam("size") int size);
}
