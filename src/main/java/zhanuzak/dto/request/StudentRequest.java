package zhanuzak.dto.request;

import lombok.Builder;
import zhanuzak.enums.IsBlocked;
import zhanuzak.enums.StudyFormat;

@Builder
public record StudentRequest(String firstName, String lastName, String phoneNumber,
                             String email, StudyFormat studyFormat, IsBlocked isBlocked) {
    public StudentRequest(String firstName, String lastName, String phoneNumber, String email,
                          StudyFormat studyFormat, IsBlocked isBlocked) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.studyFormat = studyFormat;
        this.isBlocked = isBlocked;
    }
}
