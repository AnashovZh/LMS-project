package zhanuzak.service;

import zhanuzak.request.CompanyRequest;
import zhanuzak.response.AboutCompany;
import zhanuzak.response.CompanyResponse;
import zhanuzak.response.SimpleResponse;

import java.util.List;
import java.util.Map;

public interface CompanyService {
    List<CompanyResponse> findAllCompanies();

    SimpleResponse saveCompany(CompanyRequest companyRequest);

    CompanyResponse findCompanyById(Long id);

    SimpleResponse updateCompany(Long id, CompanyRequest companyRequest);

    SimpleResponse deleteInstructor(Long id);

    SimpleResponse updateCompanyMap(Long id, Map<String, Object> fields);

    AboutCompany getCompanyAboutById(Long id);
}
