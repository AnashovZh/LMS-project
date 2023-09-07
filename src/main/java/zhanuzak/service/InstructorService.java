package zhanuzak.service;

import zhanuzak.entity.Student;
import zhanuzak.dto.request.InstructorRequest;
import zhanuzak.dto.response.AboutInstructor;
import zhanuzak.dto.response.CounterStudentByGroup;
import zhanuzak.dto.response.InstructorResponse;
import zhanuzak.dto.response.SimpleResponse;

import java.util.List;

public interface InstructorService {
    List<InstructorResponse> getAllInstructors();

    SimpleResponse saveInstructor(InstructorRequest instructorRequest);

    InstructorResponse findInstructorById(Long id);

    SimpleResponse updateInstructor(Long id, InstructorRequest instructorRequest);

    SimpleResponse deleteInstructor(Long id);

    SimpleResponse assignInstructorToCompany(Long companyId, Long id);

    CounterStudentByGroup counterStudentsByInstructor(Long id);

    SimpleResponse assignInstructorToCourse(Long courseId, Long id);

    AboutInstructor aboutAllInstructor(Long id);
    List<Student>getAllStudentsByInstructorId(Long id);
}
