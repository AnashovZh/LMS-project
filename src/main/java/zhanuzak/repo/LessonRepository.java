package zhanuzak.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import zhanuzak.entity.Lesson;
import zhanuzak.response.LessonResponse;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson,Long> {
@Query("select new zhanuzak.response.LessonResponse(l.id,l.lessonName) from Lesson l")
    List<LessonResponse> findAllLessons();
}
