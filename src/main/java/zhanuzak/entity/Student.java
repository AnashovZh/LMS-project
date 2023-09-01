package zhanuzak.entity;

import jakarta.persistence.*;
import lombok.*;
import zhanuzak.enums.StudyFormat;

import static jakarta.persistence.CascadeType.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @SequenceGenerator(name = "student_seq",allocationSize = 1)
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
    @ManyToOne(cascade = {PERSIST,REFRESH,MERGE,DETACH})
    private Group  group;

}