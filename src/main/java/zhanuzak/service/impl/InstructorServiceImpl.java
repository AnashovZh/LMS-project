package zhanuzak.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhanuzak.entity.*;
import zhanuzak.exceptions.NotFoundException;
import zhanuzak.repo.CompanyRepository;
import zhanuzak.repo.CourseRepository;
import zhanuzak.repo.InstructorRepository;
import zhanuzak.dto.request.InstructorRequest;
import zhanuzak.dto.response.AboutInstructor;
import zhanuzak.dto.response.CounterStudentByGroup;
import zhanuzak.dto.response.InstructorResponse;
import zhanuzak.dto.response.SimpleResponse;
import zhanuzak.service.InstructorService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;
    private final CompanyRepository companyRepository;
    private final CourseRepository courseRepository;

    @Override
    public List<InstructorResponse> getAllInstructors() {
        return instructorRepository.findAllInstructors();
    }

    @Override
    public SimpleResponse saveInstructor(InstructorRequest instructorRequest) {
        Instructor instructor = new Instructor();
        instructor.setFirstName(instructorRequest.firstName());
        instructor.setLastName(instructorRequest.lastName());
        instructor.setPhoneNumber(instructorRequest.phoneNumber());
        instructor.setSpecialAction(instructorRequest.specialAction());
        instructorRepository.save(instructor);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Instructor successfully saved ☺")
                .build();
    }

    @Override
    public InstructorResponse findInstructorById(Long id) {
        return instructorRepository.findInstructorById(id).orElseThrow(() ->
                new NotFoundException("Instructor with id:" + id + " not found !!!"));
    }

    @Override
    public SimpleResponse updateInstructor(Long id, InstructorRequest instructorRequest) {
        Instructor instructor = instructorRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Instructor with id:" + id + " not found !!!"));
        instructor.setFirstName(instructorRequest.firstName());
        instructor.setLastName(instructorRequest.lastName());
        instructor.setPhoneNumber(instructorRequest.phoneNumber());
        instructor.setSpecialAction(instructorRequest.specialAction());
        instructorRepository.save(instructor);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Instructor successfully update ☺")
                .build();
    }

    @Override
    public SimpleResponse deleteInstructor(Long id) {
        Instructor instructor = instructorRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Instructor with id :" + id + " not found !!!"));
        instructorRepository.delete(instructor);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Instructor with id:" + id + " successfully deleted ☺")
                .build();
    }

    @Override
    public SimpleResponse assignInstructorToCompany(Long companyId, Long id) {
        Company company = companyRepository.findById(companyId).orElseThrow(() ->
                new NotFoundException("Company with id:" + companyId + " not found !!!"));
        Instructor instructor = instructorRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Instructor with id:" + id + " not found !!!"));
        company.getInstructors().add(instructor);
        List<Company> companies = new ArrayList<>();
        companies.add(company);
        instructor.setCompanies(companies);
        companyRepository.save(company);
        instructorRepository.save(instructor);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Successfully assign ☺")
                .build();
    }

    @Override
    public CounterStudentByGroup counterStudentsByInstructor(Long id) {
        Instructor instructor = instructorRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Instructor with id:" + id + " not found !!!"));
        List<Student> students = new ArrayList<>();
        List<Course> courses = instructor.getCourses();
        for (Course c : courses) {
            for (Group g : c.getGroups()) {
                students.addAll(g.getStudents());
            }
        }
        int count = students.size();
        return CounterStudentByGroup.builder()
                .counter(count)
                .description(instructor.getFirstName() + " агайдын(эжекенин) IDси:" + id + " томонкучо окуучулары бар.")
                .build();
    }

    @Override
    public SimpleResponse assignInstructorToCourse(Long courseId, Long id) {
        Course course = courseRepository.findById(courseId).orElseThrow(() ->
                new NotFoundException("Course with id:" + courseId + " not found !!!"));
        List<Course> courses = new ArrayList<>();
        courses.add(course);
        Instructor instructor = instructorRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Instructor with id:" + id + " not found !!!"));
        course.setInstructor(instructor);
        instructor.setCourses(courses);
        instructorRepository.save(instructor);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Instructor with id:" + id + " successfully assign to Course with id:" + courseId)
                .build();
    }

    @Override
    public AboutInstructor aboutAllInstructor(Long id) {
        Instructor instructor = instructorRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Instructor with id:" + id + " not found !!!"));
        List<Student> students = getAllStudentsByInstructorId(id);
        Map<String, Integer> countSt = new HashMap<>();
        Map<String, String> studentsByInstructor = new HashMap<>();
        for (Student s : students) {
            countSt.put("Count students:", students.size());
            studentsByInstructor.put(s.getFirstName(), s.getPhoneNumber());
        }
        return AboutInstructor.builder()
                .firstName(instructor.getFirstName())
                .lastName(instructor.getLastName())
                .phoneNumber(instructor.getPhoneNumber())
                .specialAction(instructor.getSpecialAction())
                .students(studentsByInstructor)
                .counter(countSt)
                .build();
    }

    @Override
    public List<Student> getAllStudentsByInstructorId(Long id) {
        Instructor instructor = instructorRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Instructor with id:" + id + " not found !!!"));
        return instructor.getCourses().stream().flatMap(course -> course.getGroups().stream())
                .flatMap(group -> group.getStudents().stream()).collect(Collectors.toList());
    }
}
