package zhanuzak.entity;

import jakarta.persistence.*;
import lombok.*;
import zhanuzak.enums.IsBlocked;
import zhanuzak.enums.Role;
import zhanuzak.enums.StudyFormat;

import static jakarta.persistence.CascadeType.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @SequenceGenerator(name = "student_seq", allocationSize = 1)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(name = "study_format")
    private StudyFormat studyFormat;
    @Enumerated(EnumType.STRING)
    @Column(name = "is_blocked")
    private IsBlocked isBlocked;
    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToOne(cascade = {PERSIST, REFRESH, MERGE, DETACH})
    private Group group;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StudyFormat getStudyFormat() {
        return studyFormat;
    }

    public void setStudyFormat(StudyFormat studyFormat) {
        this.studyFormat = studyFormat;
    }

    public IsBlocked getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(IsBlocked isBlocked) {
        this.isBlocked = isBlocked;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}