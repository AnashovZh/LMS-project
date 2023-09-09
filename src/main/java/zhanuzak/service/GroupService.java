package zhanuzak.service;

import zhanuzak.dto.request.GroupRequest;
import zhanuzak.dto.response.CounterStudentByGroup;
import zhanuzak.dto.response.GroupResponse;
import zhanuzak.dto.response.SimpleResponse;

import java.util.List;

public interface GroupService {
    List<GroupResponse> getAllGroups();

    SimpleResponse saveGroupWithCourse(Long courseId, GroupRequest groupRequest);

    GroupResponse findGroupById(Long id);

    SimpleResponse updateGroupWithCourse(Long courseId, Long id, GroupRequest groupRequest);

    SimpleResponse deleteGroup(Long id);

    CounterStudentByGroup counterStudentsByGroup(Long groupId);

    SimpleResponse saveGroup(GroupRequest groupRequest);
}
