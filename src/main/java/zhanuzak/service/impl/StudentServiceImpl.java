package zhanuzak.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;
import zhanuzak.entity.Group;
import zhanuzak.entity.Student;
import zhanuzak.exceptions.NotFoundException;
import zhanuzak.repo.GroupRepository;
import zhanuzak.repo.StudentRepository;
import zhanuzak.dto.request.StudentRequest;
import zhanuzak.dto.response.SimpleResponse;
import zhanuzak.dto.response.StudentResponse;
import zhanuzak.service.StudentService;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        student.setIsBlocked(studentRequest.isBlocked());
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

    @Override
    public SimpleResponse isBlockedStudent(Long id, Map<String, Object> fields) {
        Student student = studentRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Student with id:" + id + " not found !!!"));
        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Student.class, key);
            if (field != null) {
                field.setAccessible(true);
                Class<?> fieldType = field.getType();

                if (fieldType.isEnum() && value instanceof String) {
                    // Convert the string value to the enum type
                    Enum<?> enumValue = Enum.valueOf((Class<Enum>) fieldType, (String) value);
                    ReflectionUtils.setField(field, student, enumValue);
                } else if (fieldType == String.class && value instanceof String) {
                    ReflectionUtils.setField(field, student, value);
                }
            }
        });

        studentRepository.save(student);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Student with id:" + student.getId() + " successfully blocked")
                .build();
    }

}