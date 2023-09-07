package zhanuzak.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zhanuzak.enums.Country;

import java.util.List;

/**
 * IV - Компанияны чакырганда толук маалыматы, курстардын аты, группалардын аты,
 * //    инструкторлордун аты, бардык студенттердин саны чыксын.
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
public class AboutCompany{

    private String name;
    private Country country;
    private String address;
    private String phoneNumber;
    private List<String>groupNames;
    private List<String> courseNames;
    private List<String> instructorNames;
    private int allStudentsOfNumber;

    public AboutCompany(String name, Country country, String address,
                        String phoneNumber, List<String> groupNames,
                        List<String> courseNames, List<String> instructorNames,
                        int allStudentsOfNumber) {
        this.name = name;
        this.country = country;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.groupNames = groupNames;
        this.courseNames = courseNames;
        this.instructorNames = instructorNames;
        this.allStudentsOfNumber = allStudentsOfNumber;
    }
}