package zhanuzak.service;

import zhanuzak.dto.request.StudentRequest;
import zhanuzak.dto.response.SimpleResponse;
import zhanuzak.dto.response.StudentResponse;

import java.util.List;
import java.util.Map;

public interface StudentService {

    List<StudentResponse> getAllStudents();


    SimpleResponse saveStudentToGroup(Long groupId, StudentRequest studentRequest);

    SimpleResponse updateStudent(Long id, StudentRequest studentRequest);

    SimpleResponse deleteStudent(Long id);

    SimpleResponse isBlockedStudent(Long id, Map<String, Object> fields);

    SimpleResponse save(StudentRequest studentRequest);

    SimpleResponse assignStudentToGroup(Long studentId, Long groupId);
}
