package University_Course_Management_System.Mapper;

import University_Course_Management_System.dto.StudentDto;
import University_Course_Management_System.model.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface Student_Mapper {

   StudentDto toDto(Student student);
   Student toEntity(StudentDto studentDto);

   List<StudentDto> toDtoList(List<Student> students);
   List<Student> toEntityList(List<StudentDto> studentDto);
}
