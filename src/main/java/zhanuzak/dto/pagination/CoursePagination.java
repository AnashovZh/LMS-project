package zhanuzak.dto.pagination;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import zhanuzak.dto.response.CourseResponse;

import java.util.List;

@Builder
@Getter
@Setter
public class CoursePagination {
    private List<CourseResponse>courses;
    private int currentPage;
    private int pageSize;
}
