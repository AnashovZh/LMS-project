package zhanuzak.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import zhanuzak.request.CourseRequest;
import zhanuzak.response.CourseResponse;
import zhanuzak.response.SimpleResponse;
import zhanuzak.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseApi {
    private final CourseService courseService;

    @GetMapping
    List<CourseResponse> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping("/{companyId}/company")
    SimpleResponse saveCourseToCompany(@PathVariable Long companyId,
                                       @RequestBody CourseRequest courseRequest) {
        return courseService.saveCourseToCompany(companyId, courseRequest);
    }

    @PostMapping
    SimpleResponse saveCourse(@RequestBody CourseRequest courseRequest) {
        return courseService.saveCourse(courseRequest);
    }

    @GetMapping("/{id}")
    CourseResponse getCourseById(@PathVariable Long id) {
        return courseService.findCourseById(id);
    }

    /**
     * V -  Курсту чыгарып жатканда датасы мн сорттолуп чыксын
     */
    @GetMapping("/dateOfStartSortCourseNew")
    List<CourseResponse> dateOfStartCourseNew() {
        return courseService.dateOfStartCourseNew();
    }


    @PutMapping("/{id}")
    SimpleResponse updateCourse(@PathVariable Long id, @RequestBody CourseRequest courseRequest) {
        return courseService.updateCourse(id, courseRequest);
    }

    @PostMapping("/{id}")
    SimpleResponse deleteCourse(@PathVariable Long id) {
        return courseService.deleteCourse(id);
    }
}
