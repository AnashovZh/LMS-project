package zhanuzak.request;

import lombok.Builder;
import zhanuzak.enums.StudyFormat;

@Builder
public record StudentRequest(String firstName, String lastName, String phoneNumber,
                             String email, StudyFormat studyFormat) {
    public StudentRequest(String firstName, String lastName, String phoneNumber,
                          String email, StudyFormat studyFormat) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.studyFormat = studyFormat;
    }
}
