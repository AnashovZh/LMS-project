package zhanuzak.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import zhanuzak.enums.IsBlocked;
import zhanuzak.enums.Role;
import zhanuzak.enums.SpecialAction;
import zhanuzak.enums.StudyFormat;
import zhanuzak.validation.EmailValidation;
import zhanuzak.validation.PhoneNumberValidation;


//Instructor
//private Long id;
//private String firstName;
//private String lastName;
//private String email;
//private String phoneNumber;
//private String password;
//private SpecialAction specialAction;
//private Role role;


//Student
//private Long id;
//private String firstName;
//private String lastName;
//private String email;
//private String phoneNumber;
//private String password;
//private StudyFormat studyFormat;
//private IsBlocked isBlocked;
//private Role role;


@Builder
public record SignRequest(String firstName, String lastName,
                          @EmailValidation
                          String email,
                          @PhoneNumberValidation
                          String phoneNumber, String password, StudyFormat studyFormat,
                          IsBlocked isBlocked, SpecialAction specialAction, Role role) {

}
