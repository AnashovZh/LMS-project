package zhanuzak.dto.pagination;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import zhanuzak.dto.response.CompanyResponse;

import java.util.List;

@Builder
@Getter
@Setter
public class CompanyPagination {
    private List<CompanyResponse> companies;
    private int currentPage;
    private int pageSize;
}
