package zhanuzak.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import zhanuzak.enums.Country;


public record CompanyRequest(String name, @Enumerated(EnumType.STRING) Country country,
        String address, String phoneNumber) {
    public CompanyRequest(String name, Country country,
                          String address, String phoneNumber) {
        this.name = name;
        this.country = country;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
