package zhanuzak.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import zhanuzak.entity.Company;
import zhanuzak.dto.response.CompanyResponse;
import zhanuzak.dto.response.StudentResponse;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query("select new zhanuzak.dto.response.CompanyResponse(c.name,c.country,c.address,c.phoneNumber) from Company c")
    List<CompanyResponse> findAllCompanies();

    @Query("select new zhanuzak.dto.response.CompanyResponse(c.name,c.country,c.address,c.phoneNumber) from Company c")
    Page<CompanyResponse> findAllCompanies(Pageable pageable);

    @Query("select  new zhanuzak.dto.response.StudentResponse(s.id,s.firstName,s.lastName,s.phoneNumber,s.email,s.studyFormat,s.isBlocked)from Student s ")
    List<StudentResponse> getAllStudentsByCompanyIdWithOnline(Long id);
}
