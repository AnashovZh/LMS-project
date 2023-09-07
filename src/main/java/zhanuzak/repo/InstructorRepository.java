package zhanuzak.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import zhanuzak.entity.Instructor;
import zhanuzak.dto.response.InstructorResponse;

import java.util.List;
import java.util.Optional;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    @Query("select new zhanuzak.dto.response.InstructorResponse(i.id,i.firstName,i.lastName,i.phoneNumber,i.specialAction) from Instructor i")
    List<InstructorResponse> findAllInstructors();
    Optional<InstructorResponse> findInstructorById(Long id);

}
