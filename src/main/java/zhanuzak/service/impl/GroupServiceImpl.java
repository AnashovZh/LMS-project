package zhanuzak.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhanuzak.entity.Course;
import zhanuzak.entity.Group;
import zhanuzak.entity.Student;
import zhanuzak.exceptions.NotFoundException;
import zhanuzak.repo.CourseRepository;
import zhanuzak.repo.GroupRepository;
import zhanuzak.request.GroupRequest;
import zhanuzak.response.CounterStudentByGroup;
import zhanuzak.response.GroupResponse;
import zhanuzak.response.SimpleResponse;
import zhanuzak.service.GroupService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final CourseRepository courseRepository;

    @Override
    public List<GroupResponse> getAllGroups() {
        return groupRepository.findAllGroups();
    }

    @Override
    public SimpleResponse saveGroup(Long courseId, GroupRequest groupRequest) {
        Course course = courseRepository.findById(courseId).orElseThrow(() ->
                new NotFoundException("Course with id:" + courseId + " not found !!!"));
        List<Course> courses = new ArrayList<>();
        courses.add(course);
        Group group = new Group();
        group.setGroupName(groupRequest.groupName());
        group.setImageLink(groupRequest.imageLink());
        group.setDescription(groupRequest.description());
        group.setCourses(courses);
        groupRepository.save(group);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.CREATED)
                .message("Group with id:" + group.getId() + " successfully saved ☺")
                .build();
    }

    @Override
    public GroupResponse findGroupById(Long id) {
        GroupResponse groupById = groupRepository.findGroupById(id);
        return groupById;
    }

    @Override
    public SimpleResponse updateGroupWithCourse(Long courseId, Long id, GroupRequest groupRequest) {
        Course course = courseRepository.findById(courseId).orElseThrow(() ->
                new NotFoundException("Course wtiht id:" + courseId + " not found!!!"));
        List<Course> courses = new ArrayList<>();
        courses.add(course);
        Group group = groupRepository.findById(id).orElseThrow(() -> new NotFoundException("" +
                "Group with id:" + id + " not found!!!"));
        group.setGroupName(groupRequest.groupName());
        group.setImageLink(groupRequest.imageLink());
        group.setDescription(groupRequest.description());
        group.setCourses(courses);
        groupRepository.save(group);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Group with id:" + id + " successfully updated ☺")
                .build();
    }

    @Override
    public SimpleResponse deleteGroup(Long id) {
        Group group = groupRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Group with id:" + id + " not found!!!"));
        groupRepository.delete(group);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Group with id:" + id + " successfully deleted ☺")
                .build();
    }

    @Override
    public CounterStudentByGroup counterStudentsByGroup(Long groupId) {
        Group group = groupRepository.findById(groupId).orElseThrow(() ->
                new NotFoundException("Group with id:" + groupId + " not found!!!"));
        int counter = (int) group.getStudents().stream().count();
        return CounterStudentByGroup.builder()
                .counter(counter)
                .description("There are so many students in the Group with this id:" + groupId)
                .build();
    }
}
