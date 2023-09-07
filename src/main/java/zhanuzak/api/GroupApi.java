package zhanuzak.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import zhanuzak.dto.request.GroupRequest;
import zhanuzak.dto.response.CounterStudentByGroup;
import zhanuzak.dto.response.GroupResponse;
import zhanuzak.dto.response.SimpleResponse;
import zhanuzak.service.GroupService;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupApi {
    private final GroupService groupService;

    @GetMapping
    List<GroupResponse> getAllGroups() {
        return groupService.getAllGroups();
    }

    @PostMapping("/save/{courseId}")
    SimpleResponse saveGroup(@PathVariable Long courseId,
                             @RequestBody GroupRequest groupRequest) {
        return groupService.saveGroup(courseId, groupRequest);
    }

    @GetMapping("/{id}")
    GroupResponse findGroupById(@PathVariable Long id) {
        return groupService.findGroupById(id);
    }

    @PutMapping("/{courseId}/update/{id}")
    SimpleResponse updateGroup(@PathVariable Long courseId,
                               @PathVariable Long id,
                               @RequestBody GroupRequest groupRequest) {
        return groupService.updateGroupWithCourse(courseId, id, groupRequest);
    }

    @PostMapping("/{id}")
    SimpleResponse deleteGroup(@PathVariable Long id) {
        return groupService.deleteGroup(id);
    }

    @GetMapping("/{groupId}/students")
    CounterStudentByGroup counterStudentsByGroup(@PathVariable Long groupId) {
        return groupService.counterStudentsByGroup(groupId);
    }



}
