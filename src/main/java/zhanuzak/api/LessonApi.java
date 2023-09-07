package zhanuzak.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import zhanuzak.dto.request.LessonRequest;
import zhanuzak.dto.response.LessonResponse;
import zhanuzak.dto.response.SimpleResponse;
import zhanuzak.service.LessonService;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
@RequiredArgsConstructor
public class LessonApi {
    private final LessonService lessonService;

    @GetMapping
    List<LessonResponse> getAllLessons() {
        return lessonService.getAllLessons();
    }

    @PostMapping("/{courseId}/course")
    SimpleResponse saveLesson(@PathVariable Long courseId,
                              @RequestBody LessonRequest lessonRequest) {
        return lessonService.saveLesson(courseId, lessonRequest);
    }

    @PutMapping("/{id}")
    SimpleResponse updateLesson(@PathVariable Long id, @RequestBody LessonRequest lessonRequest) {
        return lessonService.updateLesson(id, lessonRequest);
    }

    @PutMapping("/{courseId}/course/{id}")
    SimpleResponse updateLessonWithCourse(@PathVariable Long courseId, @PathVariable Long id, @RequestBody LessonRequest lessonRequest) {
        return lessonService.updateLessonWithCourse(courseId, id, lessonRequest);
    }

    @PostMapping("/{id}")
    SimpleResponse deleteLesson(@PathVariable Long id) {
        return lessonService.deleteLesson(id);
    }
}
