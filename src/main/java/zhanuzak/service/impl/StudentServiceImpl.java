package zhanuzak.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhanuzak.entity.Group;
import zhanuzak.entity.Student;
import zhanuzak.exceptions.NotFoundException;
import zhanuzak.repo.GroupRepository;
import zhanuzak.repo.StudentRepository;
import zhanuzak.request.StudentRequest;
import zhanuzak.response.SimpleResponse;
import zhanuzak.response.StudentResponse;
import zhanuzak.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    @Override
    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAllStudents();
    }

    @Override
    public SimpleResponse saveStudent(StudentRequest studentRequest) {
        Student student = new Student();
        student.setFirstName(studentRequest.firstName());
        student.setLastName(studentRequest.lastName());
        student.setPhoneNumber(studentRequest.phoneNumber());
        student.setEmail(studentRequest.email());
        student.setStudyFormat(studentRequest.studyFormat());
        studentRepository.save(student);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.CREATED)
                .message("Student with id:" + student.getId() + " successfully saved ☺")
                .build();
    }

    @Override
    public SimpleResponse saveStudentToGroup(Long groupId, Long id) {
        Group group = groupRepository.findById(groupId).orElseThrow(() ->
                new NotFoundException("Group with id:" + groupId + " not found!!!"));
        Student student = studentRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Student with id:" + id + " not found!!!"));
        List<Student> students = new ArrayList<>();
        students.add(student);
        group.setStudents(students);
        student.setGroup(group);
        studentRepository.save(student);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.CREATED)
                .message("Student with id:" + id + " successfully assigned to Group with id:" + groupId)
                .build();
    }

    @Override
    public SimpleResponse updateStudent(Long id, StudentRequest studentRequest) {
        Student student = studentRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Student with id:" + id + " not found!!!"));
        student.setFirstName(studentRequest.firstName());
        student.setLastName(studentRequest.lastName());
        student.setPhoneNumber(studentRequest.phoneNumber());
        student.setEmail(studentRequest.email());
        student.setStudyFormat(studentRequest.studyFormat());
        studentRepository.save(student);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Student with id:" + id + " successfully updated ☺")
                .build();
    }

    @Override
    public SimpleResponse deleteStudent(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Student with id:" + id + " not found !!!"));
        studentRepository.delete(student);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Student with id:" + id + " successfully deleted ☺")
                .build();
    }
}
