package zhanuzak.service;

import zhanuzak.request.CourseRequest;
import zhanuzak.response.CourseResponse;
import zhanuzak.response.SimpleResponse;

import java.util.List;

public interface CourseService {
    List<CourseResponse> getAllCourses();

    SimpleResponse saveCourse(CourseRequest courseRequest);

    CourseResponse findCourseById(Long id);

    SimpleResponse updateCourse(Long id, CourseRequest courseRequest);

    SimpleResponse deleteCourse(Long id);

    SimpleResponse saveCourseToCompany(Long companyId, CourseRequest courseRequest);

    List<CourseResponse> dateOfStartCourseNew();

}
