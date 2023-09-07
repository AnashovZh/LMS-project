package zhanuzak.service;

import zhanuzak.dto.pagination.CompanyPagination;
import zhanuzak.entity.Student;
import zhanuzak.dto.request.CompanyRequest;
import zhanuzak.dto.response.AboutCompany;
import zhanuzak.dto.response.CompanyResponse;
import zhanuzak.dto.response.SimpleResponse;
import zhanuzak.dto.response.StudentResponse;

import java.util.List;
import java.util.Map;

public interface CompanyService {
    List<CompanyResponse> findAllCompanies();

    SimpleResponse saveCompany(CompanyRequest companyRequest);

    CompanyResponse findCompanyById(Long id);

    SimpleResponse updateCompany(Long id, CompanyRequest companyRequest);

    SimpleResponse deleteCompany(Long id);

    SimpleResponse updateCompanyMap(Long id, Map<String, Object> fields);

    AboutCompany getCompanyAboutById(Long id);

    List<StudentResponse> getAllStudentsOnlineEducation(Long id);
    List<Student>getAllStudents(Long id);

    List<StudentResponse> getAllStudentsOfflineEducation(Long id);

    CompanyPagination getAllPaginationCompany(int currentPage, int pageSize);
}
