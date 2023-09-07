package zhanuzak.entity;

import jakarta.persistence.*;
import lombok.*;
import zhanuzak.enums.Role;
import zhanuzak.enums.SpecialAction;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "instructors")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instructor_seq")
    @SequenceGenerator(name = "instructor_seq",allocationSize = 1)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber;
    private SpecialAction specialAction;
    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToMany(cascade = {PERSIST,DETACH,REFRESH,MERGE})
    private List<Company> companies;
    @OneToMany(mappedBy = "instructor",cascade = {PERSIST,DETACH,REFRESH,MERGE})
    private List<Course>courses;

}