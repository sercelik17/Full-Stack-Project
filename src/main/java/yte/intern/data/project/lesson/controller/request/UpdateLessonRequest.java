package yte.intern.data.project.lesson.controller.request;

import yte.intern.data.project.lesson.entity.Lesson;
import yte.intern.data.project.lesson.entity.Lesson;

import java.time.LocalTime;

public record UpdateLessonRequest(
        String name,

        LocalTime zaman,

        Long akademisyenId
) {
    public Lesson toDomainEntity() {

        return new Lesson(name, zaman, akademisyenId);
    }
}
