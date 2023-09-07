package zhanuzak.service;

import zhanuzak.dto.request.LessonRequest;
import zhanuzak.dto.response.LessonResponse;
import zhanuzak.dto.response.SimpleResponse;

import java.util.List;

public interface LessonService {

    List<LessonResponse> getAllLessons();

    SimpleResponse saveLesson(Long courseId, LessonRequest lessonRequest);

    SimpleResponse updateLesson(Long id, LessonRequest lessonRequest);

    SimpleResponse updateLessonWithCourse(Long courseId, Long id, LessonRequest lessonRequest);

    SimpleResponse deleteLesson(Long id);
}
