package zhanuzak.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import zhanuzak.request.StudentRequest;
import zhanuzak.response.SimpleResponse;
import zhanuzak.response.StudentResponse;
import zhanuzak.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentApi {
    private final StudentService studentService;

    @GetMapping()
    List<StudentResponse> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    SimpleResponse saveStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.saveStudent(studentRequest);
    }

    @PostMapping("/{groupId}/group/{id}")
    SimpleResponse saveStudentToGroup(@PathVariable Long groupId, @PathVariable Long id) {
        return studentService.saveStudentToGroup(groupId, id);
    }

    @PutMapping("/{id}")
    SimpleResponse updateStudent(@PathVariable Long id, @RequestBody StudentRequest studentRequest) {
        return studentService.updateStudent(id, studentRequest);
    }

    @PostMapping("/{id}")
    SimpleResponse deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }

}
