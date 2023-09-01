package zhanuzak.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import zhanuzak.request.InstructorRequest;
import zhanuzak.response.AboutInstructor;
import zhanuzak.response.CounterStudentByGroup;
import zhanuzak.response.InstructorResponse;
import zhanuzak.response.SimpleResponse;
import zhanuzak.service.InstructorService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/instructors")
@RequiredArgsConstructor
public class InstructorApi {
    private final InstructorService instructorService;

    @GetMapping
    List<InstructorResponse> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @PostMapping
    SimpleResponse saveInstructor(@RequestBody InstructorRequest instructorRequest) {
        return instructorService.saveInstructor(instructorRequest);
    }

    @GetMapping("/{id}")
    InstructorResponse getInstructorById(@PathVariable Long id) {
        return instructorService.findInstructorById(id);
    }

    @PutMapping("/{id}")
    SimpleResponse updateInstructor(@PathVariable Long id, InstructorRequest instructorRequest) {
        return instructorService.updateInstructor(id, instructorRequest);
    }

    @PostMapping("/{id}")
    SimpleResponse deleteInstructor(@PathVariable Long id) {
        return instructorService.deleteInstructor(id);
    }

    @PostMapping("/{companyId}/{id}")
    SimpleResponse assignInstructorToCompany(@PathVariable Long companyId,
                                             @PathVariable Long id) {
        return instructorService.assignInstructorToCompany(companyId, id);
    }

    @GetMapping("/{id}/students")
    CounterStudentByGroup counterStudentsByInstructor(@PathVariable Long id) {
        return instructorService.counterStudentsByInstructor(id);
    }

    @PostMapping("/{courseId}/assignToCourse/{id}")
    SimpleResponse assignInstructorToCourse(@PathVariable Long courseId,
                                            @PathVariable Long id) {
        return instructorService.assignInstructorToCourse(courseId, id);
    }

    @GetMapping("/aboutInstructor/{id}")
    AboutInstructor aboutAllInstructor(@PathVariable Long id) {
        return instructorService.aboutAllInstructor(id);
    }

}
