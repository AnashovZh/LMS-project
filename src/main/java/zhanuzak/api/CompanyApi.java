package zhanuzak.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import zhanuzak.dto.pagination.CompanyPagination;
import zhanuzak.dto.request.CompanyRequest;
import zhanuzak.dto.response.AboutCompany;
import zhanuzak.dto.response.CompanyResponse;
import zhanuzak.dto.response.SimpleResponse;
import zhanuzak.dto.response.StudentResponse;
import zhanuzak.service.CompanyService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class CompanyApi {
    private final CompanyService companyService;

    @GetMapping
    List<CompanyResponse> getAllCompanies() {
        return companyService.findAllCompanies();
    }

    @PostMapping
    SimpleResponse saveCompany(@RequestBody CompanyRequest companyRequest) {
        return companyService.saveCompany(companyRequest);
    }

    @GetMapping("/{id}")
    CompanyResponse getById(@PathVariable Long id) {
        return companyService.findCompanyById(id);
    }

    /**
     * IV - Компанияны чакырганда толук маалыматы, курстардын аты, группалардын аты,
     * //    инструкторлордун аты, бардык студенттердин саны чыксын.
     */
    @GetMapping("/aboutCompany/{id}")
    AboutCompany getCompanyAboutById(@PathVariable Long id) {
        return companyService.getCompanyAboutById(id);
    }


    @PutMapping("/{id}")
    SimpleResponse updateCompany(@PathVariable Long id,
                                 @RequestBody CompanyRequest companyRequest) {
        return companyService.updateCompany(id, companyRequest);
    }

    @PostMapping("/u/{id}")
    SimpleResponse updateCompanyById(@PathVariable Long id,
                                     @RequestBody Map<String, Object> fields) {
        return companyService.updateCompanyMap(id, fields);
    }

    @PostMapping("/{id}")
    SimpleResponse deleteCompany(@PathVariable Long id) {
        return companyService.deleteCompany(id);
    }

    @GetMapping("{id}/students/online")
    List<StudentResponse> getAllStudentsOnlineEducation(@PathVariable Long id) {
        return companyService.getAllStudentsOnlineEducation(id);
    }

    @GetMapping("{id}/students/offline")
    List<StudentResponse> getAllStudentsOfflineEducation(@PathVariable Long id) {
        return companyService.getAllStudentsOfflineEducation(id);
    }

    @GetMapping("/pagination")
    public CompanyPagination paginationCompany(@RequestParam int currentPage,
                                               @RequestParam int pageSize) {
        return companyService.getAllPaginationCompany(currentPage, pageSize);

    }
}
