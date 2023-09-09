package zhanuzak.service;

import zhanuzak.dto.request.TaskRequest;
import zhanuzak.dto.response.SimpleResponse;
import zhanuzak.dto.response.TaskResponse;

import java.util.List;

public interface TaskService {
    List<TaskResponse> getAllTasks();

    SimpleResponse saveTaskToLesson(Long lessonId, TaskRequest taskRequest);

    TaskResponse getTaskById(Long id);

    SimpleResponse updateTaskWithLesson(Long lessonId, Long id, TaskRequest taskRequest);

    SimpleResponse deleteTask(Long id);

    SimpleResponse saveTask(TaskRequest taskRequest);
}
