package zhanuzak.service;

import zhanuzak.request.TaskRequest;
import zhanuzak.response.SimpleResponse;
import zhanuzak.response.TaskResponse;

import java.util.List;

public interface TaskService {
    List<TaskResponse> getAllTasks();

    SimpleResponse saveTask(Long lessonId, TaskRequest taskRequest);

    TaskResponse getTaskById(Long id);

    SimpleResponse updateTaskWithLesson(Long lessonId, Long id, TaskRequest taskRequest);

    SimpleResponse deleteTask(Long id);
}
