package zhanuzak.dto.request;

import lombok.Builder;
import zhanuzak.enums.Role;
import zhanuzak.enums.SpecialAction;
import zhanuzak.validation.EmailValidation;
import zhanuzak.validation.PhoneNumberValidation;
//private Long id;
//private String firstName;
//private String lastName;
//private String email;
//private String phoneNumber;
//private String password;
//private SpecialAction specialAction;
//private Role role;

@Builder
public record InstructorRequest(String firstName,
                                String lastName,
                                @EmailValidation(message = "Invalid email format")
                                String email,
                                @PhoneNumberValidation
                                String phoneNumber,
                                String password,
                                SpecialAction specialAction,
                                Role role) {

}
