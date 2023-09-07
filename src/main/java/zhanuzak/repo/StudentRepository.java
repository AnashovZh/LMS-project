package zhanuzak.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import zhanuzak.entity.Student;
import zhanuzak.dto.response.StudentResponse;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select new zhanuzak.dto.response.StudentResponse(s.id,s.firstName," +
            "s.lastName,s.phoneNumber,s.email,s.studyFormat,s.isBlocked) from Student s ")
    List<StudentResponse> findAllStudents();
}
