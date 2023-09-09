package zhanuzak.api;

import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PermitAll
    @GetMapping
    List<CompanyResponse> getAllCompanies() {
        return companyService.findAllCompanies();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    SimpleResponse saveCompany(@RequestBody @Valid CompanyRequest companyRequest) {
        return companyService.saveCompany(companyRequest);
    }

    @PermitAll
    @GetMapping("/{id}")
    CompanyResponse getById(@PathVariable Long id) {
        return companyService.findCompanyById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/aboutCompany/{id}")
    AboutCompany getCompanyAboutById(@PathVariable Long id) {
        return companyService.getCompanyAboutById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    SimpleResponse updateCompany(@PathVariable Long id,
                                 @RequestBody CompanyRequest companyRequest) {
        return companyService.updateCompany(id, companyRequest);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/u/{id}")
    SimpleResponse updateCompanyById(@PathVariable Long id,
                                     @RequestBody Map<String, Object> fields) {
        return companyService.updateCompanyMap(id, fields);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/{id}")
    SimpleResponse deleteCompany(@PathVariable Long id) {
        return companyService.deleteCompany(id);
    }

    @PermitAll
    @GetMapping("{id}/students/online")
    List<StudentResponse> getAllStudentsOnlineEducation(@PathVariable Long id) {
        return companyService.getAllStudentsOnlineEducation(id);
    }

    @PermitAll
    @GetMapping("{id}/students/offline")
    List<StudentResponse> getAllStudentsOfflineEducation(@PathVariable Long id) {
        return companyService.getAllStudentsOfflineEducation(id);
    }
     @PermitAll
    @GetMapping("/pagination")
    public CompanyPagination paginationCompany(@RequestParam int currentPage,
                                               @RequestParam int pageSize) {
        return companyService.getAllPaginationCompany(currentPage, pageSize);

    }
}
