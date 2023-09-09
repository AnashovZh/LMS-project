package zhanuzak.dto.request;

import lombok.Builder;
import zhanuzak.enums.IsBlocked;
import zhanuzak.enums.Role;
import zhanuzak.enums.StudyFormat;
import zhanuzak.validation.EmailValidation;
import zhanuzak.validation.PhoneNumberValidation;

@Builder
public record StudentRequest(String firstName,
                             String lastName,
                             @EmailValidation
                             String email,
                             @PhoneNumberValidation
                             String phoneNumber,
                             String password,
                             StudyFormat studyFormat,
                             IsBlocked isBlocked,
                             Role role) {

}
