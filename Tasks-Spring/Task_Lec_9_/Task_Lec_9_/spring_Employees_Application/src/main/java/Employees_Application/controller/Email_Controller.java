package Employees_Application.controller;

import Employees_Application.dto.Email_Dto;
import Employees_Application.service.Email_Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class Email_Controller {

    Email_Service emailService;

    @Autowired
    public Email_Controller(Email_Service emailService) {
        this.emailService = emailService;
    }



//___________________________________________________


    @PostMapping("/saveEmail")
    public ResponseEntity<Email_Dto> saveEmail (@RequestBody  @Valid Email_Dto emailDto) throws URISyntaxException {
        return ResponseEntity.created(new URI("/saveEmail")).body(emailService.saveEmail(emailDto));
    }
//________________________________________________________________________________

    @GetMapping("/getEmailByName")
    public ResponseEntity<Email_Dto> getEmailByName(@RequestParam @Valid String name)
    {
        return ResponseEntity.ok(emailService.getEmailByName(name));
    }

    //________________________________________________________________________________

   @GetMapping("/getEmailByListOfNames")
    public ResponseEntity<List<Email_Dto>> getEmailByListOfName(@RequestParam @Valid List<String> names)
    {
        return ResponseEntity.ok(emailService.getEmailByListOfName(names));
    }



    //________________________________________________________________________________


    @DeleteMapping("/deleteEmailById")
    public ResponseEntity<Void> deleteEmailById(@RequestParam Long id)
    {
        emailService.deleteEmailById(id);
        return ResponseEntity.noContent().build();
    }


    //________________________________________________________________________________
    @PutMapping("/updateEmail")
    public ResponseEntity<Email_Dto> updateEmail(@RequestBody @Valid Email_Dto emailDto)
    {
        return ResponseEntity.ok(emailService.updateEmail(emailDto));
    }



    //________________________________________________________________________________

    @GetMapping("/getAllEmails")
    public ResponseEntity<List<Email_Dto>> getAllEmails()
    {
        return ResponseEntity.ok(emailService.getAllEmails());
    }



    //________________________________________________________________________________

    @GetMapping("/getEmailByContent")
    public ResponseEntity<Email_Dto> getEmailByContent(@RequestParam @Valid String content)
    {
        return ResponseEntity.ok(emailService.getEmailByContent(content));
    }


//________________________________________________________________________________

    @PostMapping("/registerFromEmployeeToEmail/{employeeId}/{emailId}")
public ResponseEntity<Email_Dto> registerFromEmployeeToEmail(@PathVariable Long employeeId, @PathVariable Long emailId) {
        return ResponseEntity.ok(emailService.registerFromEmployeeToEmail(employeeId, emailId));
}

//________________________________________________________________________________


}
