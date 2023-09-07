package zhanuzak.dto.request;

import lombok.Builder;
import zhanuzak.enums.SpecialAction;

@Builder
public record InstructorRequest(String firstName, String lastName, String phoneNumber, SpecialAction specialAction) {

    public InstructorRequest(String firstName, String lastName, String phoneNumber, SpecialAction specialAction) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.specialAction = specialAction;
    }
}
