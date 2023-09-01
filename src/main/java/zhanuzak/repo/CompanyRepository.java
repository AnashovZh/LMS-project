package zhanuzak.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import zhanuzak.entity.Company;
import zhanuzak.response.CompanyResponse;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company,Long> {
    @Query("select new zhanuzak.response.CompanyResponse(c.name,c.country,c.address,c.phoneNumber) from Company c")
    List<CompanyResponse> findAllCompanies();
}
