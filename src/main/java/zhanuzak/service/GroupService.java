package zhanuzak.service;

import zhanuzak.request.GroupRequest;
import zhanuzak.response.CounterStudentByGroup;
import zhanuzak.response.GroupResponse;
import zhanuzak.response.SimpleResponse;

import java.util.List;

public interface GroupService {
    List<GroupResponse> getAllGroups();

    SimpleResponse saveGroup(Long courseId, GroupRequest groupRequest);

    GroupResponse findGroupById(Long id);

    SimpleResponse updateGroupWithCourse(Long courseId, Long id, GroupRequest groupRequest);

    SimpleResponse deleteGroup(Long id);

    CounterStudentByGroup counterStudentsByGroup(Long groupId);
}
