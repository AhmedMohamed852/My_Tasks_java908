package Employees_Application.service.impl;



import Employees_Application.dto.Email_Dto;
import Employees_Application.maper.Email_Mapper;
import Employees_Application.model.Email;
import Employees_Application.model.Employee_E;
import Employees_Application.repo.Email_Repo;
import Employees_Application.repo.Employee_Repo;
import Employees_Application.service.Email_Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class Email_impl implements Email_Service {


   private final Email_Repo emailRepo;
   private final Email_Mapper emailMapper;
   private final Employee_Repo employeeRepo;

   @Autowired
  public Email_impl(Email_Repo emailRepo, Email_Mapper emailMapper , Employee_Repo employeeRepo)
   {
       this.emailRepo = emailRepo;
       this.emailMapper = emailMapper;
       this.employeeRepo = employeeRepo;
   }



//_______________________________________________________________________

    @Override
    public Email_Dto saveEmail(Email_Dto emailDto) {
        Optional<Email> email = emailRepo.findByContent(emailDto.getContent());

        if(email.isPresent())
        {
            throw new RuntimeException("Email with this Content already exists");
        }

        if(Objects.nonNull(emailDto.getId()))
        {
            throw new RuntimeException("id must be null");
        }

        Email email1 = emailMapper.toEntity(emailDto);
        Email saved = emailRepo.save(email1);
        return emailMapper.toDto(saved);
    }


//________________________________________________________________________________


    @Override
    public Email_Dto getEmailByName(String name)
    {
        Optional<Email> email = emailRepo.findByName(name);
        if(email.isEmpty())
        {
            throw new RuntimeException("Email with this name does not exist");
        }

        Email email1 = email.get();

        return emailMapper.toDto(email1);
    }

//________________________________________________________________________________


    @Override
    public List<Email_Dto> getEmailByListOfName(List<String> names) {
        return  emailMapper.toDtoList(emailRepo.findAllByNameIn(names).get());
    }


//________________________________________________________________________________



    @Override
    public void deleteEmailById(Long id) {
        emailRepo.deleteById(id);
    }


//________________________________________________________________________________

    @Override
    public Email_Dto updateEmail(Email_Dto emailDto) {
       Optional<Email> email = emailRepo.findById(emailDto.getId());

        if(Objects.isNull(emailDto.getId()))
        {
            throw new RuntimeException("id must be null");
        }


       if(email.isEmpty())
       {
           throw new RuntimeException("Email with this id does not exist");
       }


      return emailMapper.toDto( emailRepo.save(emailMapper.toEntity(emailDto)));

    }

//________________________________________________________________________________


    @Override
    public List<Email_Dto>  getAllEmails() {
        return emailMapper.toDtoList(emailRepo.findAll());
    }


//________________________________________________________________________________

    @Override
    public Email_Dto  getEmailByContent(String content) {
       Optional<Email> email = emailRepo.findByContent(content);
        return emailMapper.toDto(email.get());
    }


//________________________________________________________________________________


    @Override
    public Email_Dto registerFromEmployeeToEmail(Long employeeId, Long emailId) {
       Optional<Email> email = emailRepo.findById(emailId);
       Optional<Employee_E> employee = employeeRepo.findById(employeeId);
       if(email.isEmpty() || employee.isEmpty())
       {
           throw new RuntimeException("Email or Employee does not exist");
       }

     Email_Dto emailDto = emailMapper.toDto(email.get());
       emailDto.setEmployee(employee.get());
       return emailDto;
    }
}
