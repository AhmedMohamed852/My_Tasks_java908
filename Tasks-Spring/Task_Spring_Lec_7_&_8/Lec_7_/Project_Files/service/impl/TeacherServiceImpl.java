package com.springbootproject_1.service.impl;

import com.springbootproject_1.model.Teacher;
import com.springbootproject_1.repo.TeacherRepo;
import com.springbootproject_1.service.TeacherService;
import dto.TeacherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    private  TeacherRepo teacherRepo;
    @Autowired
    public TeacherServiceImpl(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }



    //________________________________GET_ALL_TEACHERS__________________________________

    @Override
    public List<TeacherDto> getAllTeachers() {
        List<Teacher> teachers = teacherRepo.findAll();

        List<TeacherDto> teacherDto = teachers.stream().map(teacher -> new TeacherDto
              (teacher.getId(),teacher.getUsername(),teacher.getPassword())).collect(Collectors.toList());

        teacherDto.forEach(teacher -> teacher.setConcat(teacher.getUsername() +" " + teacher.getPassword()));

       return teacherDto;


    }




    //________________________________GET_TEACHER_BY_ID__________________________________

    @Override
    public TeacherDto getTeacherById(long id)  {

        Optional <Teacher> teacherOptional = teacherRepo.findById(id);
        if(teacherOptional.isEmpty())
        { throw new RuntimeException("TeacherDto not found with id :" + id); }

        Teacher teacher = teacherOptional.get();
        TeacherDto teacherDto = new TeacherDto(teacher.getId(),teacher.getUsername(),teacher.getPassword());
        teacherDto.setConcat(teacher.getUsername() +" " + teacher.getPassword());
        return teacherDto;
    }






    //________________________________GET_TEACHER_BY_USERNAME__________________________________

    @Override
    public TeacherDto getTeacherByUsername(String username) {
        Optional <Teacher> teacherOptional = teacherRepo.findByUsername(username);
        if(teacherOptional.isEmpty())
        {throw new RuntimeException("TeacherDto not found with username :" + username);}

        Teacher teacher = teacherOptional.get();

        TeacherDto teacherDto = new TeacherDto(teacher.getId(),teacher.getUsername(),teacher.getPassword());
        teacherDto.setConcat(teacher.getUsername() +" " + teacher.getPassword());
         return teacherDto ;
    }






    //________________________________ADD_TEACHER__________________________________
    @Override
    public TeacherDto addTeacher(TeacherDto teacherDto)  {
        Optional <Teacher> teacherOptional = teacherRepo.findByUsername(teacherDto.getUsername());

        if(teacherDto.getId() != 0 )
        {
            throw new RuntimeException("must be id is null");
        }

        if(teacherOptional.isPresent())
        {
            throw new RuntimeException("userName must be unique");
        }


        if(Objects.isNull(teacherDto.getUsername()))
        {
            throw new RuntimeException("userName must be not null");
        }

        if(Objects.isNull(teacherDto.getPassword()))
        {
            throw new RuntimeException("password must be not null");
        }

       Teacher teacher = teacherRepo.save(new Teacher(teacherDto.getUsername(),teacherDto.getPassword()));

        teacherDto.setId(teacher.getId());
        teacherDto.setConcat(teacher.getUsername() +" " + teacher.getPassword());

        return (teacherDto);
    }





    //________________________________UPDATE_TEACHER__________________________________

    @Override
    public TeacherDto updateTeacher(TeacherDto teacherDto) {

        Optional <Teacher> teacherOptional = teacherRepo.findById(teacherDto.getId());
        if(teacherOptional.isEmpty()){
        throw new RuntimeException("TeacherDto not found");
        }

        teacherRepo.save(new Teacher(teacherDto.getId() ,teacherDto.getUsername() ,teacherDto.getPassword()));
        teacherDto.setConcat(teacherDto.getUsername() +" " + teacherDto.getPassword());

        return teacherDto;
    }





    //________________________________DELETE_TEACHER_BY_ID__________________________________
    @Override
    public void deleteTeacherById(Long id)  {

        Optional <Teacher> teacher = teacherRepo.findById(id);
        if(teacher.isEmpty()){
            throw new RuntimeException("can't Delete TeacherDto not found");
        }


        teacherRepo.deleteById(id);
    }

}
