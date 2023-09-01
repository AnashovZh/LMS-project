package zhanuzak.response;

import lombok.Builder;
import zhanuzak.enums.SpecialAction;

@Builder

public record InstructorResponse(Long id,String firstName, String lastName, String phoneNumber, SpecialAction specialAction) {
    public InstructorResponse(Long id,String firstName, String lastName, String phoneNumber, SpecialAction specialAction) {
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.specialAction = specialAction;
    }


}
