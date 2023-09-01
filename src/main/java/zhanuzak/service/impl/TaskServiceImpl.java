package zhanuzak.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhanuzak.entity.Lesson;
import zhanuzak.entity.Task;
import zhanuzak.exceptions.NotFoundException;
import zhanuzak.repo.LessonRepository;
import zhanuzak.repo.TaskRepository;
import zhanuzak.request.TaskRequest;
import zhanuzak.response.SimpleResponse;
import zhanuzak.response.TaskResponse;
import zhanuzak.service.TaskService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final LessonRepository lessonRepository;

    @Override
    public List<TaskResponse> getAllTasks() {
        return taskRepository.findAllTasks();
    }

    @Override
    public SimpleResponse saveTask(Long lessonId, TaskRequest taskRequest) {
        Lesson lesson = lessonRepository.findById(lessonId).orElseThrow(() ->
                new NotFoundException("Lesson with id:" + lessonId + " not found !!!"));
        Task task = new Task();
        task.setTaskName(taskRequest.taskName());
        task.setTaskText(taskRequest.taskText());
        task.setDeadLine(taskRequest.deadLine());
        task.setLesson(lesson);
        taskRepository.save(task);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Task with id:" + lesson.getId() + " successfully saved ☺ to Lesson with id:" + lessonId)
                .build();
    }

    @Override
    public TaskResponse getTaskById(Long id) {
        return taskRepository.findTaskById(id);
    }

    @Override
    public SimpleResponse updateTaskWithLesson(Long lessonId, Long id, TaskRequest taskRequest) {
        Lesson lesson = lessonRepository.findById(lessonId).orElseThrow(() ->
                new NotFoundException("Lesson with id:" + lessonId + " not found !!!"));
        Task task = taskRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Task with id:" + id + " not found !!!"));
        task.setTaskName(taskRequest.taskName());
        task.setTaskText(taskRequest.taskText());
        task.setDeadLine(taskRequest.deadLine());
        task.setLesson(lesson);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Task with id:" + id + "successfully updated ☺ along with Lesson with id:" + lessonId)
                .build();
    }

    @Override
    public SimpleResponse deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Task with id:" + id + " not found !!!"));
        taskRepository.delete(task);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Task with id:" + id + " successfully deleted ☺ ")
                .build();
    }
}
