package zhanuzak.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhanuzak.dto.pagination.CoursePagination;
import zhanuzak.entity.Company;
import zhanuzak.entity.Course;
import zhanuzak.exceptions.NotFoundException;
import zhanuzak.repo.CompanyRepository;
import zhanuzak.repo.CourseRepository;
import zhanuzak.dto.request.CourseRequest;
import zhanuzak.dto.response.CourseResponse;
import zhanuzak.dto.response.SimpleResponse;
import zhanuzak.service.CourseService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CompanyRepository companyRepository;

    @Override
    public List<CourseResponse> getAllCourses() {
        return courseRepository.findAllCourses();
    }


    @Override
    public CourseResponse findCourseById(Long id) {
//        Course course = courseRepository.findById(id).orElseThrow(() ->
//        new NotFoundException("Course  with id:" + id + " not found !!!"));
        CourseResponse courseRes = courseRepository.findCourseById(id);
        return courseRes;
    }

    @Override
    public SimpleResponse updateCourse(Long id, CourseRequest courseRequest) {

        Course course = courseRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Course with id:" + id + " not found!!"));
        course.setCourseName(courseRequest.courseName());
        course.setDescription(courseRequest.description());
        course.setDateOfStart(courseRequest.dateOfStart());
        courseRepository.save(course);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.CREATED)
                .message("Successfully saved Course ☺ with id:" + id)
                .build();
    }

    @Override
    public SimpleResponse deleteCourse(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Course with id:" + id + " not found!!!"));
        courseRepository.delete(course);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Course with id:" + id + " successfully deleted ☺")
                .build();
    }

    @Override
    public SimpleResponse saveCourseToCompany(Long companyId, CourseRequest courseRequest) {
        Company company = companyRepository.findById(companyId).orElseThrow(() ->
                new NotFoundException("Company with id:" + companyId + " not found !!!"));
        Course course = new Course();
        course.setCourseName(courseRequest.courseName());
        course.setDateOfStart(courseRequest.dateOfStart());
        course.setDescription(courseRequest.description());
        course.setCompany(company);
        courseRepository.save(course);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Course with id:" + course.getId() + " successfully saved ☺ in a Company with id:" + companyId)
                .build();
    }

    @Override
    public List<CourseResponse> dateOfStartCourseNew() {
        return courseRepository.dateOfStartCourseNew();
    }

    @Override
    public List<CourseResponse> dateOfStartCourseOwns() {
        return courseRepository.dateOfStartCourseOwns();
    }

    @Override
    public CoursePagination getAllCoursesPagination(int currenPage, int pageSize) {
        Pageable pageable= PageRequest.of(currenPage,pageSize);
        Page<CourseResponse>courses=courseRepository.findAllCourses(pageable);
        return CoursePagination.builder()
                .courses(courses.getContent())
                .currentPage(courses.getNumber())
                .pageSize(courses.getTotalPages())
                .build();

    }
}
