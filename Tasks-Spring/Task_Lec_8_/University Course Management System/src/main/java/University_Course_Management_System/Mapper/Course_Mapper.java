package University_Course_Management_System.Mapper;


import University_Course_Management_System.dto.CourseDto;
import University_Course_Management_System.dto.StudentDto;
import University_Course_Management_System.model.Course;
import University_Course_Management_System.model.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface Course_Mapper {


    CourseDto toDto(Course course);
    Course toEntity(CourseDto courseDto);

    List<CourseDto> toDtoList(List<Course> courses);
    List<Course> toEntityList(List<CourseDto> courseDto);
}
