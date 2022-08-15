package yte.intern.data.project.lesson.service; //security ve security test dependency eklemeyi unutma

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yte.intern.data.project.akademisyen.entity.Akademisyen;
import yte.intern.data.project.akademisyen.service.AkademisyenService;
import yte.intern.data.project.lesson.entity.Lesson;
import yte.intern.data.project.lesson.repository.LessonRepository;
import yte.intern.data.project.common.response.MessageResponse;
import yte.intern.data.project.common.response.ResponseType;
import yte.intern.data.project.lesson.entity.Lesson;
import yte.intern.data.project.lesson.repository.LessonRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonService {
    private final LessonRepository lessonRepository;
        private final AkademisyenService akademisyenService;

    public MessageResponse addLesson(Lesson lesson) {
        Akademisyen akademisyen = akademisyenService.getById(lesson.getAkademisyen().getId());
        lesson.setAkademisyen(akademisyen);

        lessonRepository.save(lesson);

        return new MessageResponse(ResponseType.SUCCESS, "Lesson has been added successfully");
    }

    public List<Lesson> getAllLessons() {

        return lessonRepository.findAll();
    }

    public Lesson getById(Long id) {
        return lessonRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lesson not found"));
    }

    public MessageResponse deleteLessonById(Long id) {
        lessonRepository.deleteById(id);
        return new MessageResponse(ResponseType.SUCCESS, "Lesson has been deleted successfully");
    }

    public MessageResponse updatedLesson(Long id, Lesson updatedLesson) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lesson not found"));

        Akademisyen akademisyen = akademisyenService.getById(updatedLesson.getAkademisyen().getId());
        updatedLesson.setAkademisyen(akademisyen);

        lesson.update(updatedLesson);

        lessonRepository.save(lesson);

        return new MessageResponse(ResponseType.SUCCESS, "Lesson has been updated successfully");
    }
}
