package zhanuzak.service;

import zhanuzak.request.LessonRequest;
import zhanuzak.response.LessonResponse;
import zhanuzak.response.SimpleResponse;

import java.util.List;

public interface LessonService {

    List<LessonResponse> getAllLessons();

    SimpleResponse saveLesson(Long courseId, LessonRequest lessonRequest);

    SimpleResponse updateLesson(Long id, LessonRequest lessonRequest);

    SimpleResponse updateLessonWithCourse(Long courseId, Long id, LessonRequest lessonRequest);

    SimpleResponse deleteLesson(Long id);
}
