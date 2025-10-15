package Employees_Application.service;

import Employees_Application.dto.Email_Dto;
import Employees_Application.model.Email;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Email_Service {
  Email_Dto saveEmail(Email_Dto emailDto);

  Email_Dto getEmailByName(String name);

    List<Email_Dto> getEmailByListOfName(List<String> names);

   void deleteEmailById(Long id);

   Email_Dto updateEmail(Email_Dto emailDto);

    List<Email_Dto> getAllEmails();

    Email_Dto getEmailByContent(String content);

    Email_Dto registerFromEmployeeToEmail(Long employeeId , Long emailId);
}
