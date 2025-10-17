package Employees_Application.maper;


import Employees_Application.dto.Email_Dto;
import Employees_Application.model.Email;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface Email_Mapper {

  Email toEntity(Email_Dto emailDto );

   Email_Dto toDto(Email email);
   List<Email_Dto> toDtoList(List<Email> emailList);

}
