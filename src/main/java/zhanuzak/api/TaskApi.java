package zhanuzak.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import zhanuzak.dto.request.TaskRequest;
import zhanuzak.dto.response.SimpleResponse;
import zhanuzak.dto.response.TaskResponse;
import zhanuzak.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskApi {
    private final TaskService taskService;

    @GetMapping
    List<TaskResponse> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("/{lessonId}/lesson")
    SimpleResponse saveTask(@PathVariable Long lessonId,
                            @RequestBody TaskRequest taskRequest) {
        return taskService.saveTask(lessonId, taskRequest);
    }

    @GetMapping("/{id}")
    TaskResponse getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/{lessonId}/update/{id}")
    SimpleResponse updateTaskWithTheLesson(@PathVariable Long lessonId,
                                           @PathVariable Long id,
                                           @RequestBody TaskRequest taskRequest) {
        return taskService.updateTaskWithLesson(lessonId, id, taskRequest);
    }

    @PostMapping("/{id}")
    SimpleResponse deleteTask(@PathVariable Long id) {
        return taskService.deleteTask(id);
    }

}
