package yte.intern.data.project.lesson.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.data.project.lesson.entity.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
