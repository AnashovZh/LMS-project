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


    InstructorResponse findInstructorById(Long id);

    SimpleResponse updateInstructor(Long id, InstructorRequest instructorRequest);

    SimpleResponse deleteInstructor(Long id);

    SimpleResponse saveInstructorToCompany(Long companyId, InstructorRequest instructorRequest);

    CounterStudentByGroup counterStudentsByInstructor(Long id);

    SimpleResponse assignInstructorToCourse(Long courseId, Long id);

    AboutInstructor aboutAllInstructor(Long id);
    List<Student>getAllStudentsByInstructorId(Long id);

    SimpleResponse deleteInstructorSimple(Long id);

    SimpleResponse saveInstructor(InstructorRequest instructorRequest);

    SimpleResponse assignInstructorToCompany(Long companyId, Long id);
}
