package zhanuzak.service;

import zhanuzak.request.StudentRequest;
import zhanuzak.response.SimpleResponse;
import zhanuzak.response.StudentResponse;

import java.util.List;

public interface StudentService {

    List<StudentResponse> getAllStudents();

    SimpleResponse saveStudent(StudentRequest studentRequest);

    SimpleResponse saveStudentToGroup(Long groupId, Long id);

    SimpleResponse updateStudent(Long id, StudentRequest studentRequest);

    SimpleResponse deleteStudent(Long id);
}
