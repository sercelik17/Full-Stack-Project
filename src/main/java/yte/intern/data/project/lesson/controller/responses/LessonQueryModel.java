package yte.intern.data.project.lesson.controller.responses;

import yte.intern.data.project.lesson.service.LessonService;
import yte.intern.data.project.lesson.entity.Lesson;

import java.time.LocalTime;


public record LessonQueryModel(
        Long id,
        String name,
        LocalTime zaman
) {
    public LessonQueryModel(Lesson lesson) {
        this(
                lesson.getId(),
                lesson.getName(),
                lesson.getZaman()

        );
    }


}
