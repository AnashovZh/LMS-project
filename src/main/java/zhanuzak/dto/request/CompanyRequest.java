package zhanuzak.dto.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import zhanuzak.enums.Country;
import zhanuzak.validation.PhoneNumberValidation;


public record CompanyRequest(String name,

                             Country country,
                             String address,
                             @PhoneNumberValidation
                             String phoneNumber) {
    public CompanyRequest(String name, Country country,
                          String address, String phoneNumber) {
        this.name = name;
        this.country = country;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
