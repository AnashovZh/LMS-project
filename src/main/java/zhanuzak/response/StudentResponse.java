package zhanuzak.response;

import lombok.Builder;
import zhanuzak.enums.StudyFormat;



@Builder
public record StudentResponse(Long id, String firstName, String lastName,
                   String phoneNumber, String email, StudyFormat studyFormat) {
    public StudentResponse(Long id, String firstName, String lastName, String phoneNumber,
                           String email, StudyFormat studyFormat) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.studyFormat = studyFormat;
    }
}
